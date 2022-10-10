package org.hiforce.lattice.sample.business.realization;

import com.google.common.collect.Lists;
import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ability.ext.BlankReduceSampleExt;
import org.hiforce.lattice.sample.business.SampleBusiness;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Realization(codes = SampleBusiness.CODE)
public class SampleBusinessExt extends BlankReduceSampleExt {

    @Override
    public String firstNotNullReducePolicy() {
        return "SampleBusiness Hello World!";
    }

    @Override
    public List<String> getCustomListResult() {
        return Lists.newArrayList("Jack", "Tom");
    }
}
