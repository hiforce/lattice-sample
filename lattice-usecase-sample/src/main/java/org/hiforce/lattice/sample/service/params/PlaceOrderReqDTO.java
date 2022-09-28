package org.hiforce.lattice.sample.service.params;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class PlaceOrderReqDTO implements Serializable {

    private static final long serialVersionUID = 5052974619507635546L;

    @Getter
    @Setter
    private long itemId;

    @Getter
    @Setter
    private int buyQuantity;

    @Getter
    @Setter
    private String source;


    @Getter
    @Setter
    private String scenario;

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();
}
