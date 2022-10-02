package org.hiforce.lattice.sample.usecase.presale.ability;

import org.hifforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.usecase.presale.model.PreSaleOrderLine;
import org.hiforce.lattice.sample.usecase.presale.sdk.BlankPreSaleTradeSDK;

import java.math.BigDecimal;
import java.util.Objects;

import static org.hiforce.lattice.sample.usecase.presale.sdk.PreSaleTradeSDK.EXT_PRE_SALE_CUSTOM_DOWN_PAY_RATIO;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Ability(name = "PreSale OrderLine Ability")
public class PreSaleOrderLineAbility extends BaseLatticeAbility<BlankPreSaleTradeSDK> {

    public PreSaleOrderLineAbility(PreSaleOrderLine orderLine) {
        super(orderLine);
    }

    public BigDecimal getCustomDownPaymentRatio() {
        Double ratio = reduceExecute(
                BlankPreSaleTradeSDK::getCustomDownPaymentRatio,
                Reducers.firstOf(Objects::nonNull));
        return (null == ratio || ratio > 1) ? new BigDecimal(1) : new BigDecimal(ratio);
    }

    @Override
    public BlankPreSaleTradeSDK getDefaultRealization() {
        return new BlankPreSaleTradeSDK();
    }
}
