package org.hiforce.sample.cloth.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ext.SampleItemPriceExt;
import org.hiforce.sample.cloth.BusinessCloth;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
@Realization(codes = BusinessCloth.CODE)
public class ClothBusinessExt extends SampleItemPriceExt {
    @Override
    public Long getCustomItemPrice() {
        return 1000L;
    }
}
