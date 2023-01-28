package org.hiforce.lattice.sample.model;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
public class OrderLine implements IBizObject {

    @Getter
    @Setter
    private long orderLineId = SequenceGenerator.next(OrderLine.class.getName());

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private String scenario;

    @Getter
    @Setter
    private Long unitPrice;

    @Getter
    @Setter
    private Long defaultPostFee = 10000L;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Override
    public BizContext getBizContext() {

        return new BizContext() {

            private static final long serialVersionUID = 5644480983225009669L;

            @Override
            public Serializable getBizId() {
                return orderLineId;
            }

            @Override
            public String getBizCode() {
                return bizCode;
            }

            @Override
            public String getScenario() {
                return scenario;
            }
        };
    }
}
