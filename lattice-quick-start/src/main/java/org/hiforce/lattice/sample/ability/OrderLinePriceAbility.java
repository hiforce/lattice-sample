package org.hiforce.lattice.sample.ability;

import org.hifforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

import java.util.Objects;
import java.util.Optional;

import static org.hiforce.lattice.sample.ability.ext.OrderLinePriceExt.EXT_ORDER_LINE_CUSTOM_UNIT_PRICE;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Ability(name = "OrderLine's Price Ability")
public class OrderLinePriceAbility extends BaseLatticeAbility<BlankOrderLinePriceExt> {

    public OrderLinePriceAbility(OrderLine bizObject) {
        super(bizObject);
    }

    public Long getCustomUnitPrice(OrderLine orderLine) {
        return Optional.ofNullable(reduceExecute(EXT_ORDER_LINE_CUSTOM_UNIT_PRICE,
                        p -> p.getCustomUnitPrice(orderLine),
                        Reducers.firstOf(Objects::nonNull)))
                .orElse(orderLine.getUnitPrice());
    }

    @Override
    public BlankOrderLinePriceExt getDefaultRealization() {
        return new BlankOrderLinePriceExt();
    }
}
