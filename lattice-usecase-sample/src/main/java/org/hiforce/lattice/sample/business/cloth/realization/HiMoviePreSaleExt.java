package org.hiforce.lattice.sample.business.cloth.realization;

import org.hifforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.business.cloth.HiMovieBusiness;
import org.hiforce.lattice.sample.usecase.presale.sdk.BlankPreSaleTradeSDK;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Realization(codes = HiMovieBusiness.CODE)
public class HiMoviePreSaleExt extends BlankPreSaleTradeSDK {

    @Override
    public Double getCustomDownPaymentRatio() {
        return 0.75;
    }
}
