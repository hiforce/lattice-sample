package org.hiforce.lattice.dynamic.product;

import org.hiforce.lattice.annotation.Product;
import org.hiforce.lattice.model.business.ProductTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/10/13
 */
@Product(code = "SampleProduct", name = "SampleProduct")
public class SampleProduct extends ProductTemplate {

    public static boolean sampleProductSwitch = false;

    @Override
    public boolean isEffect(ScenarioRequest request) {
        return sampleProductSwitch;
    }
}
