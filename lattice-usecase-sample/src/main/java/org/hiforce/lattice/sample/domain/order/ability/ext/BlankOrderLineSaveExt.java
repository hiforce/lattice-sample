package org.hiforce.lattice.sample.domain.order.ability.ext;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class BlankOrderLineSaveExt extends BusinessExt implements OrderLineSaveExt {


    @Override
    public BigDecimal getItemCustomUnitPrice(OrderLine orderLine) {
        return null;
    }

    @Override
    public Map<String, String> getCustomOrderAttributes(OrderLine orderLine) {
        return null;
    }
}
