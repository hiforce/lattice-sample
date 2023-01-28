package org.hiforce.lattice.sample.ability.normal.ext;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
public interface NormalLogisticsExt extends IBusinessExt {

    @Extension(
            code = "EXT_NORMAL_LOGISTICS_CUSTOM_POST_FEE",
            reduceType = ReduceType.FIRST
    )
    Long getCustomPostFee(OrderLine orderLine);
}
