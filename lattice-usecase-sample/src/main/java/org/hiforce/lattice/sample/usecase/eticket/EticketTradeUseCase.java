package org.hiforce.lattice.sample.usecase.eticket;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.UseCase;
import org.hiforce.lattice.model.business.UseCaseTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.domain.order.model.OrderLineItem;
import org.hiforce.lattice.sample.scenario.buy.request.BuyScenarioRequest;
import org.hiforce.lattice.sample.usecase.eticket.sdk.BlankETicketTradeSDK;
import org.hiforce.lattice.sample.usecase.eticket.sdk.ETicketTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@UseCase(
        code = EticketTradeUseCase.CODE,
        name = "ETicket Trade UseCase",
        sdk = BlankETicketTradeSDK.class
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
