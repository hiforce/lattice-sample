package org.hiforce.lattice.sample.ability.normal.ext;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
public class BlankNormalLogisticsExt extends BusinessExt implements NormalLogisticsExt {

    @Override
    public Long getCustomPostFee(OrderLine orderLine) {
        return null;
    }
}
