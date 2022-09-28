package org.hiforce.lattice.sample.scenario.buy.result;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@NoArgsConstructor
public class OrderLineResult implements Serializable {

    private static final long serialVersionUID = -5632665973644172031L;

    @Getter
    @Setter
    private long orderLineId;

    @Getter
    @Setter
    private long itemId;

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private long totalPay;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    public OrderLineResult(OrderLine orderLine) {
        this.orderLineId = orderLine.getOrderLineId();
        this.itemId = orderLine.getItem().getItemId();
        this.bizCode = orderLine.getBizCode();
    }
}
