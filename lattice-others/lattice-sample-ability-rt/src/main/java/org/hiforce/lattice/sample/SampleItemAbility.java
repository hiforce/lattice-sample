package org.hiforce.lattice.sample;

import org.hifforce.lattice.annotation.Ability;
import org.hifforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ext.SampleItemPriceExt;
import org.hiforce.lattice.sample.model.SampleItem;

import java.util.Objects;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
@Ability(name = "Sample Item Ability")
public class SampleItemAbility extends BaseLatticeAbility<SampleItemPriceExt> {

    public SampleItemAbility(SampleItem item) {
        super(item);
    }

    public Long getCustomItemPrice() {
        return reduceExecute(
                SampleItemPriceExt::getCustomItemPrice,
                Reducers.firstOf(Objects::nonNull));
    }

    @Override
    public SampleItemPriceExt getDefaultRealization() {
        return new SampleItemPriceExt();
    }
}
