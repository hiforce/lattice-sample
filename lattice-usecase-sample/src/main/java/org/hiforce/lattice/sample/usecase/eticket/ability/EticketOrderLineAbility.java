package org.hiforce.lattice.sample.usecase.eticket.ability;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.usecase.eticket.model.ETicketOrderLine;
import org.hiforce.lattice.sample.usecase.eticket.sdk.BlankETicketTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Ability(name = "EticketOrderLineAbility")
public class EticketOrderLineAbility extends BaseLatticeAbility<BlankETicketTradeSDK> {

    public EticketOrderLineAbility(ETicketOrderLine orderLine) {
        super(orderLine);
    }


    public Boolean isVoucherSupportMultiWriteOff() {
        return this.reduceExecute(
                BlankETicketTradeSDK::isVoucherSupportMultiWriteOff,
                Reducers.allMatch(p -> p == null || p));
    }

    @Override
    public BlankETicketTradeSDK getDefaultRealization() {
        return new BlankETicketTradeSDK();
    }
}
