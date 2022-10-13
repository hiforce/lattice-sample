package org.hiforce.sample.dynamic.ext;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ext.SampleItemPriceExt;

/**
 * @author Rocky Yu
 * @since 2022/10/13
 */
@Realization(codes = "DynamicTestProduct")
public class DynamicTestProductExt extends SampleItemPriceExt {

    @Override
    public Long getCustomItemPrice() {
        return 6060L;
    }
}
