package org.hiforce.lattice.sample.usecase.eticket.sdk;

import org.hifforce.lattice.model.ability.BusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class BlankETicketTradeSDK extends BusinessExt implements ETicketTradeSDK {
    @Override
    public Boolean isVoucherSupportMultiWriteOff() {
        return null;
    }
}
