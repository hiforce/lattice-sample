package org.hiforce.lattice.sample.ability.offline;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.Priority;
import org.hiforce.lattice.sample.ability.LogisticsAbility;
import org.hiforce.lattice.sample.ability.offline.ext.BlankOfflineLogisticsExt;
import org.hiforce.lattice.sample.model.LogisticsOrderDO;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
@Priority(value = 400)
public class OfflineLogisticsAbility extends LogisticsAbility<BlankOfflineLogisticsExt> {

    private final OrderLine orderLine;

    public OfflineLogisticsAbility(OrderLine orderLine) {
        super(orderLine);
        this.orderLine = orderLine;
    }

    @Override
    public String getName() {
        return "Offline";
    }

    @Override
    public long getPostFee() {
        return 0;
    }

    @Override
    public void enrichLogisticsOrderDO(LogisticsOrderDO logisticsOrderDO) {

    }

    @Override
    public boolean supportChecking() {
        String value = orderLine.getAttributes().get("lg_offline");
        return StringUtils.equals(value, "true");
    }

    @Override
    public BlankOfflineLogisticsExt getDefaultRealization() {
        return new BlankOfflineLogisticsExt();
    }
}
