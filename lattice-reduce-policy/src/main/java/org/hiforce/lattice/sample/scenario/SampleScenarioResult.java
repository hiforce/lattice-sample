package org.hiforce.lattice.sample.scenario;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public class SampleScenarioResult implements Serializable {

    @Getter
    @Setter
    private String firstNotNullResult;

    @Getter
    @Setter
    private List<List<String>> noneReduceResult;

    @Getter
    @Setter
    private List<String> flatListResult;
}
