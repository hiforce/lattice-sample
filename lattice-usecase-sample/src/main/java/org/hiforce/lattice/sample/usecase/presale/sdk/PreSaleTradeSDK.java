package org.hiforce.lattice.sample.usecase.presale.sdk;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.model.ability.IBusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public interface PreSaleTradeSDK extends IBusinessExt {

    String EXT_PRE_SALE_CUSTOM_DOWN_PAY_RATIO = "EXT_PRE_SALE_CUSTOM_DOWN_PAY_RATIO";

    @Extension(
            code = EXT_PRE_SALE_CUSTOM_DOWN_PAY_RATIO,
            name = "Custom PreSale Down Payment Ratio",
            reduceType = ReduceType.FIRST
    )
    Double getCustomDownPaymentRatio();

    String EXT_PRE_SALE_CUSTOM_PHASES = "EXT_PRE_SALE_CUSTOM_PHASES";

    @Extension(
            code = EXT_PRE_SALE_CUSTOM_PHASES,
            name = "Custom PreSale Phases Numbers",
            reduceType = ReduceType.FIRST
    )
    Integer getCustomPreSalePhases();
}
