package org.hiforce.lattice.sample.product;

import org.hifforce.lattice.annotation.Product;
import org.hifforce.lattice.model.business.ProductTemplate;
import org.hifforce.lattice.model.scenario.ScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Product(code = SampleProduct.CODE, name = SampleProduct.CODE)
public class SampleProduct extends ProductTemplate {

    public static final String CODE = "SampleProduct";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        return true;
    }
}
