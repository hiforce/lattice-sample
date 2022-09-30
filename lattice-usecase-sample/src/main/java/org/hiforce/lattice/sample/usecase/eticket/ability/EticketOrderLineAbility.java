package org.hiforce.lattice.sample.usecase.eticket.ability;

import org.hifforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.usecase.eticket.model.ETicketOrderLine;
import org.hiforce.lattice.sample.usecase.eticket.sdk.BlankETicketTradeSDK;

import static org.hiforce.lattice.sample.usecase.eticket.sdk.ETicketTradeSDK.EXT_ETICKET_IS_SUPPORT_MULTI_WRITE_OFF;

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
        return this.reduceExecute(EXT_ETICKET_IS_SUPPORT_MULTI_WRITE_OFF,
                BlankETicketTradeSDK::isVoucherSupportMultiWriteOff,
                Reducers.allMatch(p -> p == null || p));
    }

    @Override
    public BlankETicketTradeSDK getDefaultRealization() {
        return new BlankETicketTradeSDK();
    }
}
