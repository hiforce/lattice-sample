package org.hiforce.lattice.sample.ability.ext;

import org.hifforce.lattice.annotation.Extension;
import org.hifforce.lattice.annotation.model.ReduceType;
import org.hifforce.lattice.model.ability.IBusinessExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
public interface OrderLinePriceExt extends IBusinessExt {

    String EXT_ORDER_LINE_CUSTOM_UNIT_PRICE = "OrderLinePriceExt.EXT_ORDER_LINE_CUSTOM_UNIT_PRICE";

    @Extension(
            code = EXT_ORDER_LINE_CUSTOM_UNIT_PRICE,
            name = "Custom the Item's unit price of OrderLine",
            reduceType = ReduceType.FIRST
    )
    Long getCustomUnitPrice(OrderLine orderLine);
}
