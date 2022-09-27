package org.hiforce.lattice.sample.business;

import org.hifforce.lattice.annotation.Business;
import org.hifforce.lattice.model.business.BusinessTemplate;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Business(code = SampleBusiness.CODE, name = "SampleBusiness")
public class SampleBusiness extends BusinessTemplate {

    public static final String CODE = "SampleBusiness";
}
