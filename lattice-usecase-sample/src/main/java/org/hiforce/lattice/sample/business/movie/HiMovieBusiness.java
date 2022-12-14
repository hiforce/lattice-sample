package org.hiforce.lattice.sample.business.movie;

import org.hiforce.lattice.annotation.Business;
import org.hiforce.lattice.model.business.BusinessTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.scenario.buy.request.BuyScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Business(code = HiMovieBusiness.CODE, name = "Movie Business")
public class HiMovieBusiness extends BusinessTemplate {

    public static final String CODE = "hi.movie";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof BuyScenarioRequest) {
            return isEffect((BuyScenarioRequest) request);
        }
        return super.isEffect(request);
    }

    private boolean isEffect(BuyScenarioRequest request) {
        return request.getOrderLine().getItem().getTags().contains(9527);
    }
}
