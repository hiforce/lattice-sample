package org.hiforce.lattice.sample.domain.order.model;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class OrderLineItem implements Serializable {

    private static final long serialVersionUID = -4857751754837328460L;

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
}
