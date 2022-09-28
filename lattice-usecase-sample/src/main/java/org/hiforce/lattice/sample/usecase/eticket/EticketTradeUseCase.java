package org.hiforce.lattice.sample.usecase.eticket;

import org.apache.commons.lang3.StringUtils;
import org.hifforce.lattice.annotation.UseCase;
import org.hifforce.lattice.model.business.UseCaseTemplate;
import org.hifforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.domain.order.model.OrderLineItem;
import org.hiforce.lattice.sample.scenario.buy.request.BuyScenarioRequest;
import org.hiforce.lattice.sample.usecase.eticket.sdk.ETicketTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@UseCase(
        code = EticketTradeUseCase.CODE,
        name = "ETicket Trade UseCase",
        sdk = ETicketTradeSDK.class
)
public class EticketTradeUseCase extends UseCaseTemplate {

    public static final String CODE = "EticketTradeUseCase";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof BuyScenarioRequest) {
            return isEffect((BuyScenarioRequest) request);
        }
        return false;
    }

    private boolean isEffect(BuyScenarioRequest request) {
        OrderLineItem item = request.getBizObject().getItem();
        String value = item.getAttributes().get("eticket");
        return StringUtils.equals(value, "1");
    }
}
