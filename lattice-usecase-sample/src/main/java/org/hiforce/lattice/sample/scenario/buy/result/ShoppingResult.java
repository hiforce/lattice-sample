package org.hiforce.lattice.sample.scenario.buy.result;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class ShoppingResult implements Serializable {

    private static final long serialVersionUID = -1456209271727483128L;

    @Getter
    private final List<OrderLineResult> orderLineResults = Lists.newArrayList();
}
