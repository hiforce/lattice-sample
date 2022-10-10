package org.hiforce.lattice.sample.ability.ext;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
public class BlankOrderLinePriceExt extends BusinessExt implements OrderLinePriceExt {

    @Override
    public Long getCustomUnitPrice(OrderLine orderLine) {
        return null;
    }
}
