package org.hiforce.lattice.sample.ability;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.sample.model.LogisticsOrderDO;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
@Ability(name = "Logistics ability")
public abstract class LogisticsAbility<T extends IBusinessExt> extends BaseLatticeAbility<T> {

    public LogisticsAbility(OrderLine orderLine) {
        super(orderLine);
    }

    public abstract String getName();

    public abstract long getPostFee();


    public abstract void enrichLogisticsOrderDO(LogisticsOrderDO logisticsOrderDO);
}
