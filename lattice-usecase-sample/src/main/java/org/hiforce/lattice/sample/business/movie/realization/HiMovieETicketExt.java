package org.hiforce.lattice.sample.business.movie.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.business.movie.HiMovieBusiness;
import org.hiforce.lattice.sample.usecase.eticket.sdk.BlankETicketTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Realization(codes = HiMovieBusiness.CODE)
public class HiMovieETicketExt extends BlankETicketTradeSDK {

    @Override
    public Boolean isVoucherSupportMultiWriteOff() {
        return false;
    }
}
