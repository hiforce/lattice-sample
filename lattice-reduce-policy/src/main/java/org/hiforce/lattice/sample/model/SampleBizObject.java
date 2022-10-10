package org.hiforce.lattice.sample.model;

import lombok.Getter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public class SampleBizObject implements IBizObject {

    @Getter
    private final String bizCode;

    @Getter
    private String scenario;

    @Getter
    private final Long bizId = SequenceGenerator.next(SampleBizObject.class.getName());

    public SampleBizObject(String bizCode) {
        this.bizCode = bizCode;
    }

    public SampleBizObject(String bizCode, String scenario) {
        this.bizCode = bizCode;
        this.scenario = scenario;
    }

    @Override
    public BizContext getBizContext() {
        return new BizContext() {

            @Override
            public Long getBizId() {
                return bizId;
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
