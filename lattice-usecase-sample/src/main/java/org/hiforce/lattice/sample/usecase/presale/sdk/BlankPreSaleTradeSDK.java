package org.hiforce.lattice.sample.usecase.presale.sdk;

import org.hiforce.lattice.model.ability.BusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class BlankPreSaleTradeSDK extends BusinessExt implements PreSaleTradeSDK {

    @Override
    public Double getCustomDownPaymentRatio() {
        return null;
    }

    @Override
    public Integer getCustomPreSalePhases() {
        return null;
    }
}
