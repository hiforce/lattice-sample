package org.hiforce.lattice.sample.ability;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.ability.ext.OrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
@Ability(name = "OrderLine's Price Ability")
public class OrderLinePriceAbility extends BaseLatticeAbility<OrderLinePriceExt> {

    public OrderLinePriceAbility(OrderLine bizObject) {
        super(bizObject);
    }

    public Long getCustomUnitPrice(OrderLine orderLine) {
        return Optional.ofNullable(reduceExecute(p -> p.getCustomUnitPrice(orderLine),
                        Reducers.firstOf(Objects::nonNull)))
                .orElse(orderLine.getUnitPrice());
    }

    @Override
    public BlankOrderLinePriceExt getDefaultRealization() {
        return new BlankOrderLinePriceExt();
    }
}
