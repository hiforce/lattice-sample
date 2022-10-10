package org.hiforce.lattice.sample.ability.ext;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.model.ability.IBusinessExt;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/27
 */
public interface ReduceSampleExt extends IBusinessExt {

    String EXT_FIRST_NOT_NULL_POLICY = "EXT_FIRST_NOT_NULL_POLICY";

    @Extension(code = EXT_FIRST_NOT_NULL_POLICY, reduceType = ReduceType.FIRST)
    String firstNotNullReducePolicy();

    String EXT_CUSTOM_LIST_RESULT = "EXT_CUSTOM_LIST_RESULT";

    @Extension(code = EXT_CUSTOM_LIST_RESULT)
    List<String> getCustomListResult();
}
