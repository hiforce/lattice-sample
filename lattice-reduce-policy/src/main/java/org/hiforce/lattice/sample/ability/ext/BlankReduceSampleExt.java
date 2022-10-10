package org.hiforce.lattice.sample.ability.ext;

import org.hiforce.lattice.model.ability.BusinessExt;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public class BlankReduceSampleExt extends BusinessExt implements ReduceSampleExt {

    @Override
    public String firstNotNullReducePolicy() {
        return null;
    }

    @Override
    public List<String> getCustomListResult() {

        return null;
    }
}
