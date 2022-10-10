package org.hiforce.lattice.sample.model;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

import java.io.Serializable;

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

    @Override
    public BizContext getBizContext() {
        return new BizContext() {

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
