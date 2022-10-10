package org.hiforce.lattice.sample.usecase.presale;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.UseCase;
import org.hiforce.lattice.model.business.UseCaseTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.domain.order.model.OrderLineItem;
import org.hiforce.lattice.sample.scenario.buy.request.BuyScenarioRequest;
import org.hiforce.lattice.sample.usecase.presale.sdk.PreSaleTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@UseCase(
        code = PreSaleTradeUseCase.CODE,
        name = "PreSale Trade UseCase",
        sdk = PreSaleTradeSDK.class
)
public class PreSaleTradeUseCase extends UseCaseTemplate {

    public static final String CODE = "PreSaleTradeUseCase";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof BuyScenarioRequest) {
            return isEffect((BuyScenarioRequest) request);
        }
        return false;
    }

    private boolean isEffect(BuyScenarioRequest request) {
        OrderLineItem item = request.getBizObject().getItem();
        String value = item.getAttributes().get("presale");
        return StringUtils.equals(value, "1");
    }
}
