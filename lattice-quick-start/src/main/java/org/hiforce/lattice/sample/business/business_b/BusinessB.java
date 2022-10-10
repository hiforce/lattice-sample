package org.hiforce.lattice.sample.business.business_b;

import org.hiforce.lattice.annotation.Business;
import org.hiforce.lattice.model.business.BusinessTemplate;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Business(code = BusinessB.CODE, name = "Business B")
public class BusinessB extends BusinessTemplate {
    public static final String CODE = "business.b";
}
