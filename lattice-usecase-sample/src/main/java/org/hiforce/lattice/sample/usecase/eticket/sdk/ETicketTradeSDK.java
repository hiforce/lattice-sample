package org.hiforce.lattice.sample.usecase.eticket.sdk;

import org.hifforce.lattice.annotation.Extension;
import org.hifforce.lattice.annotation.model.ReduceType;
import org.hifforce.lattice.model.ability.IBusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public interface ETicketTradeSDK extends IBusinessExt {

    String EXT_ETICKET_IS_SUPPORT_MULTI_WRITE_OFF = "EXT_ETICKET_IS_SUPPORT_MULTI_WRITE_OFF";

    @Extension(
            code = EXT_ETICKET_IS_SUPPORT_MULTI_WRITE_OFF,
            name = "Is Voucher support multiple write-off",
            reduceType = ReduceType.NONE
    )
    Boolean isVoucherSupportMultiWriteOff();
}
