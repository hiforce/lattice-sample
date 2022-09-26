package org.hiforce.lattice.sample.business.business_b;

import org.hifforce.lattice.annotation.Business;
import org.hifforce.lattice.model.business.BusinessTemplate;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Business(code = BusinessB.CODE, name = "Business B")
public class BusinessB extends BusinessTemplate {
    public static final String CODE = "business.b";
}
