package org.hiforce.lattice.sample.domain.order.ability;

import org.apache.commons.collections4.MapUtils;
import org.hifforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.domain.order.ability.ext.BlankOrderLineSaveExt;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import static org.hiforce.lattice.sample.domain.order.ability.ext.OrderLineSaveExt.EXT_ENTITY_ORDER_LINE_CUSTOM_ATTRIBUTES;
import static org.hiforce.lattice.sample.domain.order.ability.ext.OrderLineSaveExt.EXT_ENTITY_ORDER_LINE_UNIT_PRICE;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Ability(name = "OrderLine Entity Save Ability")
public class OrderLineSaveAbility extends BaseLatticeAbility<BlankOrderLineSaveExt> {

    public OrderLineSaveAbility(OrderLine orderLine) {
        super(orderLine);
    }

    public BigDecimal calcOrderLinePayPrice() {
        BigDecimal price = getItemCustomUnitPrice();
        return price.multiply(new BigDecimal(getOrderLine().getBuyQuantity()));
    }

    public Map<String, String> getCustomOrderAttributes(OrderLine orderLine) {
        return reduceExecute(EXT_ENTITY_ORDER_LINE_CUSTOM_ATTRIBUTES,
                p -> p.getCustomOrderAttributes(orderLine),
                Reducers.flatMap(MapUtils::isNotEmpty));
    }

    private BigDecimal getItemCustomUnitPrice() {
        BigDecimal price = reduceExecute(EXT_ENTITY_ORDER_LINE_UNIT_PRICE,
                p -> p.getItemCustomUnitPrice(getOrderLine()),
                Reducers.firstOf(Objects::nonNull));
        if (null == price) {
            return new BigDecimal(getOrderLine().getItem().getUnitPrice());
        }
        return price;
    }

    @Override
    public BlankOrderLineSaveExt getDefaultRealization() {
        return new BlankOrderLineSaveExt();
    }

    private OrderLine getOrderLine() {
        return (OrderLine) getContext().getBizObject();
    }
}
