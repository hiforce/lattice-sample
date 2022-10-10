package org.hiforce.lattice.scenario;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/23
 */
public class BuyScenarioRequest implements ScenarioRequest {

    @Getter
    private final OrderLine orderLine;

    @Getter
    @Setter
    private String source;

    public BuyScenarioRequest(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    @Override
    public OrderLine getBizObject() {
        return orderLine;
    }
}
