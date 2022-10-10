package org.hiforce.lattice.sample.ext;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.model.ability.BusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
public class SampleItemPriceExt extends BusinessExt {

    public static final String EXT_CUSTOM_PRICE = "EXT_CUSTOM_PRICE";

    @Extension(code = EXT_CUSTOM_PRICE)
    public Long getCustomItemPrice() {
        return null;
    }
}
