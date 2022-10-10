package org.hiforce.lattice.product.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.product.GroupBuyProduct;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/23
 */
@Realization(codes = GroupBuyProduct.CODE)
public class GroupBuyProductExt extends BlankOrderLinePriceExt {
    @Override
    public Long getCustomUnitPrice(OrderLine orderLine) {
        return orderLine.getUnitPrice() * 700 / 1000; //only for sample.
    }
}
