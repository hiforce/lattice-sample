package org.hiforce.lattice.dynamic.product.ext;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ext.SampleItemPriceExt;

/**
 * @author Rocky Yu
 * @since 2022/10/13
 */
@Realization(codes = "SampleProduct")
public class SampleProductExt extends SampleItemPriceExt {

    @Override
    public Long getCustomItemPrice() {
        return 5000L;
    }
}
