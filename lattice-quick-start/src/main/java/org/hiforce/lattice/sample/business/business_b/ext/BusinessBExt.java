package org.hiforce.lattice.sample.business.business_b.ext;

import org.hifforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Realization(codes = "business.b")
public class BusinessBExt extends BlankOrderLinePriceExt {

    @Override
    public Long getCustomUnitPrice(OrderLine orderLine) {
        return 1000L;
    }
}
