package org.hiforce.lattice.sample.reduce;

import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.sample.ReduceSample;
import org.hiforce.lattice.sample.ability.ReduceSampleAbility;
import org.hiforce.lattice.sample.scenario.SampleScenarioResult;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public class AnyMatchReducer {
    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();

        SampleScenarioResult result = ReduceSample.startReduceSample(request -> {
            ReduceSampleAbility ability = new ReduceSampleAbility(request.getBizObject());
            request.getResult().setAnyMatchResult(ability.anyMatchReduce());
            return request.getResult();
        });
        System.out.println("AnyMatch result => " + result.getAnyMatchResult());
    }

}
