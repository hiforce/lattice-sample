package org.hiforce.lattice.sample.ability;

import org.apache.commons.collections4.CollectionUtils;
import org.hifforce.lattice.annotation.Ability;
import org.hifforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ability.ext.BlankReduceSampleExt;

import java.util.List;
import java.util.Objects;

import static org.hiforce.lattice.sample.ability.ext.ReduceSampleExt.EXT_CUSTOM_LIST_RESULT;
import static org.hiforce.lattice.sample.ability.ext.ReduceSampleExt.EXT_FIRST_NOT_NULL_POLICY;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Ability(name = "ReduceSampleAbility")
public class ReduceSampleAbility extends BaseLatticeAbility<BlankReduceSampleExt> {
    public ReduceSampleAbility(IBizObject bizObject) {
        super(bizObject);
    }


    public List<String> flatListReduce() {
        return this.reduceExecute(EXT_CUSTOM_LIST_RESULT,
                BlankReduceSampleExt::getCustomListResult,
                Reducers.flatList(CollectionUtils::isNotEmpty));
    }

    public List<List<String>> sampleNoneReduce() {
        return this.reduceExecute(EXT_CUSTOM_LIST_RESULT,
                BlankReduceSampleExt::getCustomListResult, Reducers.none());
    }


    public String sampleFirstNotNullReduce() {
        return this.reduceExecute(EXT_FIRST_NOT_NULL_POLICY,
                BlankReduceSampleExt::firstNotNullReducePolicy, Reducers.firstOf(Objects::nonNull));
    }

    @Override
    public BlankReduceSampleExt getDefaultRealization() {
        return new BlankReduceSampleExt();
    }
}
