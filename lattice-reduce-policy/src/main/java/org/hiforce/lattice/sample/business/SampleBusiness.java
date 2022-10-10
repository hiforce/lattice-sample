package org.hiforce.lattice.sample.business;

import org.hiforce.lattice.annotation.Business;
import org.hiforce.lattice.model.business.BusinessTemplate;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Business(code = SampleBusiness.CODE, name = "SampleBusiness")
public class SampleBusiness extends BusinessTemplate {

    public static final String CODE = "SampleBusiness";
}
