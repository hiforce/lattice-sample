package org.hiforce.sample.dynamic;

import org.hiforce.lattice.annotation.Product;
import org.hiforce.lattice.model.business.ProductTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/10/13
 */
@Product(code = "DynamicTestProduct", name = "DynamicTestProduct")
public class DynamicTestProduct extends ProductTemplate {
    @Override
    public boolean isEffect(ScenarioRequest request) {
        return true;
    }
}
