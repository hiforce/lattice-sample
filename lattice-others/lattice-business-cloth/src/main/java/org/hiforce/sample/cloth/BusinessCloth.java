package org.hiforce.sample.cloth;

import org.hifforce.lattice.annotation.Business;
import org.hifforce.lattice.model.business.BusinessTemplate;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
@Business(code = BusinessCloth.CODE, name = "Cloth Business")
public class BusinessCloth extends BusinessTemplate {

    public static final String CODE = "business.cloth";
}
