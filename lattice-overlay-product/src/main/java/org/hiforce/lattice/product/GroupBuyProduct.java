package org.hiforce.lattice.product;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.Product;
import org.hiforce.lattice.model.business.ProductTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.scenario.BuyScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/9/23
 */
@Product(code = GroupBuyProduct.CODE, name = "Group Buy Trade Product")
public class GroupBuyProduct extends ProductTemplate {

    public static final String CODE = "lattice.productGroupBuyProduct";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof BuyScenarioRequest) {
            boolean effect = StringUtils.equals("groupBuy", ((BuyScenarioRequest) request).getSource());
            System.out.println("GroupBuyProduct effect status:" + effect);
            return effect;
        }
        return false;

    }
}
