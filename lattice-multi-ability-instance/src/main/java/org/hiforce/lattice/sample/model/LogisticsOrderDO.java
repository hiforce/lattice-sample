package org.hiforce.lattice.sample.model;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
public class LogisticsOrderDO implements Serializable {

    private static final long serialVersionUID = 4779107315250920353L;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();
}
