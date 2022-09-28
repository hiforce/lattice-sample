package org.hiforce.lattice.sample.domain.order.ability.ext;

import org.hifforce.lattice.annotation.Extension;
import org.hifforce.lattice.annotation.model.ReduceType;
import org.hifforce.lattice.model.ability.IBusinessExt;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public interface OrderLineSaveExt extends IBusinessExt {

    String EXT_ENTITY_ORDER_LINE_UNIT_PRICE = "EXT_ENTITY_ORDER_LINE_UNIT_PRICE";

    @Extension(
            code = EXT_ENTITY_ORDER_LINE_UNIT_PRICE,
            reduceType = ReduceType.FIRST
    )
    BigDecimal getItemCustomUnitPrice(OrderLine orderLine);

    String EXT_ENTITY_ORDER_LINE_CUSTOM_ATTRIBUTES = "EXT_ENTITY_ORDER_LINE_CUSTOM_ATTRIBUTES";

    @Extension(
            code = EXT_ENTITY_ORDER_LINE_CUSTOM_ATTRIBUTES,
            reduceType = ReduceType.NONE
    )
    Map<String, String> getCustomOrderAttributes(OrderLine orderLine);
}
