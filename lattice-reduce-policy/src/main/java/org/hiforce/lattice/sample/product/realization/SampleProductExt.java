package org.hiforce.lattice.sample.product.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.ability.ext.BlankReduceSampleExt;
import org.hiforce.lattice.sample.product.SampleProduct;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
@Realization(codes = SampleProduct.CODE)
public class SampleProductExt extends BlankReduceSampleExt {
    @Override
    public String firstNotNullReducePolicy() {
        return null;
    }

    @Override
    public List<String> getCustomListResult() {
        return null;
    }
}
