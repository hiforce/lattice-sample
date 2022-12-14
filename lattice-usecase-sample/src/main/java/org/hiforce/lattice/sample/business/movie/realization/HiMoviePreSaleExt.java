package org.hiforce.lattice.sample.business.movie.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.business.movie.HiMovieBusiness;
import org.hiforce.lattice.sample.usecase.presale.sdk.BlankPreSaleTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Realization(codes = HiMovieBusiness.CODE)
public class HiMoviePreSaleExt extends BlankPreSaleTradeSDK {

    @Override
    public Double getCustomDownPaymentRatio() {
        return 0.4;
    }
}
