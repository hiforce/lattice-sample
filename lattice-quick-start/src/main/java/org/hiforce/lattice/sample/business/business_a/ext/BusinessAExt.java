package org.hiforce.lattice.sample.business.business_a.ext;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Realization(codes = "business.a")
public class BusinessAExt extends BlankOrderLinePriceExt {
    @Override
    public Long getCustomUnitPrice(OrderLine orderLine) {
        return 2000L;
    }
}
