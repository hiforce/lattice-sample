package org.hiforce.lattice.sample.domain.order.model;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class OrderLine implements IBizObject {

    @Getter
    private final Long orderLineId = SequenceGenerator.next(OrderLine.class.getName());

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private String scenario;

    @Getter
    @Setter
    private OrderLineItem item;

    @Getter
    @Setter
    private int buyQuantity;

    @Override
    public BizContext getBizContext() {
        return new BizContext() {

            @Override
            public Long getBizId() {
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
