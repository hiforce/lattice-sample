package org.hiforce.lattice.sample.usecase.eticket.model;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hifforce.lattice.model.business.BizContext;
import org.hifforce.lattice.model.business.IBizObject;

import java.util.Map;
import java.util.Set;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class ETicketOrderLine implements IBizObject {

    @Getter
    @Setter
    private Long orderLineId;

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private String scenario;

    @Getter
    @Setter
    private long itemId;

    @Getter
    @Setter
    private long unitPrice;

    @Getter
    private final Set<Integer> tags = Sets.newHashSet();

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Getter
    @Setter
    private int buyQuantity;

    @Override
    public BizContext getBizContext() {
        return new BizContext() {

            private static final long serialVersionUID = 496274702752229006L;

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