package org.hiforce.lattice.sample.ability.normal;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.Priority;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ability.LogisticsAbility;
import org.hiforce.lattice.sample.ability.normal.ext.BlankNormalLogisticsExt;
import org.hiforce.lattice.sample.model.LogisticsOrderDO;
import org.hiforce.lattice.sample.model.OrderLine;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
@Priority(value = 300)
public class NormalLogisticsAbility extends LogisticsAbility<BlankNormalLogisticsExt> {

    private final OrderLine orderLine;

    public NormalLogisticsAbility(OrderLine orderLine) {
        super(orderLine);
        this.orderLine = orderLine;
    }

    @Override
    public String getName() {
        return "Normal";
    }

    @Override
    public boolean supportChecking() {
        String value = orderLine.getAttributes().get("lg_normal");
        return StringUtils.equals(value, "true");
    }

    @Override
    public long getPostFee() {
        Long postFee = reduceExecute(extension -> extension.getCustomPostFee(orderLine),
                Reducers.firstOf(Objects::nonNull));
        return Optional.ofNullable(postFee)
                .map(p -> postFee).orElse(orderLine.getDefaultPostFee());
    }

    @Override
    public void enrichLogisticsOrderDO(LogisticsOrderDO logisticsOrderDO) {

    }

    @Override
    public BlankNormalLogisticsExt getDefaultRealization() {
        return new BlankNormalLogisticsExt();
    }
}
