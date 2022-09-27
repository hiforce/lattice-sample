package org.hiforce.lattice.sample;

import lombok.Getter;
import lombok.Setter;
import org.hifforce.lattice.exception.LatticeRuntimeException;
import org.hifforce.lattice.model.business.IBizObject;
import org.hifforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.lattice.sample.business.SampleBusiness;
import org.hiforce.lattice.sample.model.SampleBizObject;
import org.hiforce.lattice.sample.scenario.SampleScenarioResult;

import java.util.function.Function;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public abstract class ReduceSample {

    public static class SampleFunctionReq {

        @Getter
        @Setter
        private SampleBizObject bizObject;

        @Setter
        @Getter
        private SampleScenarioResult result;

        public SampleFunctionReq(SampleBizObject bizObject, SampleScenarioResult result) {
            this.bizObject = bizObject;
            this.result = result;
        }
    }

    public static SampleScenarioResult startReduceSample(Function<SampleFunctionReq, SampleScenarioResult> function) {
        SampleBizObject bizObject = new SampleBizObject(SampleBusiness.CODE);

        try {
            return new BizSessionScope<SampleScenarioResult, SampleBizObject>(bizObject) {
                @Override
                @SuppressWarnings("all")
                protected SampleScenarioResult execute() throws LatticeRuntimeException {
                    SampleScenarioResult result = new SampleScenarioResult();
                    function.apply(new SampleFunctionReq(bizObject, result));
                    return result;
                }

                @Override
                @SuppressWarnings("all")
                public ScenarioRequest buildScenarioRequest(SampleBizObject bizObject) {
                    return new ScenarioRequest() {
                        @Override
                        public IBizObject getBizObject() {
                            return bizObject;
                        }
                    };
                }
            }.invoke();
        } catch (LatticeRuntimeException ex) {
            System.out.println(ex.getErrorMessage().getText());
            throw ex;
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }
}
