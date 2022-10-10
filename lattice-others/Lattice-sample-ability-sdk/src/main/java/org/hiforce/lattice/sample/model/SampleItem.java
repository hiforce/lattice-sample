package org.hiforce.lattice.sample.model;

import lombok.Getter;
import lombok.Setter;
import org.hifforce.lattice.model.business.BizContext;
import org.hifforce.lattice.model.business.IBizObject;
import org.hifforce.lattice.sequence.SequenceGenerator;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
public class SampleItem implements IBizObject {

    @Getter
    @Setter
    private long itemId = SequenceGenerator.next(SampleItem.class.getName());

    @Getter
    @Setter
    private String bizCode;

    @Override
    public BizContext getBizContext() {
        return new BizContext() {

            @Override
            public Serializable getBizId() {
                return itemId;
            }

            @Override
            public String getBizCode() {
                return bizCode;
            }

            @Override
            public String getScenario() {
                return null;
            }
        };
    }
}
