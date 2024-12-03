package org.hiforce.lattice.sample.business.business_b.ext;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.business.business_b.BusinessB;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Realization(codes = BusinessB.CODE)
public class BusinessBExt extends BlankOrderLinePriceExt {

    @Override
    public Long getCustomUnitPrice(OrderLine orderLine) {
        return orderLine.getUnitPrice();
    }
}
