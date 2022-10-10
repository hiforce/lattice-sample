package org.hiforce.lattice.sample.scenario.buy.request;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class BuyScenarioRequest implements ScenarioRequest {

    private static final long serialVersionUID = 6550695206439727554L;
    @Getter
    @Setter
    private OrderLine orderLine;

    @Getter
    @Setter
    private String source;


    @Getter
    @Setter
    private String scenario;

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();


    @Override
    public OrderLine getBizObject() {
        return orderLine;
    }
}
