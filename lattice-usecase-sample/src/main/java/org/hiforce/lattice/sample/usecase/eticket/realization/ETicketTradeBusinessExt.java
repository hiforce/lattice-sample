package org.hiforce.lattice.sample.usecase.eticket.realization;

import com.google.common.collect.Maps;
import org.hifforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.domain.order.ability.ext.BlankOrderLineSaveExt;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;
import org.hiforce.lattice.sample.usecase.eticket.EticketTradeUseCase;
import org.hiforce.lattice.sample.usecase.eticket.ability.EticketOrderLineAbility;
import org.hiforce.lattice.sample.usecase.eticket.model.ETicketOrderLine;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Realization(codes = EticketTradeUseCase.CODE)
public class ETicketTradeBusinessExt extends BlankOrderLineSaveExt {

    @Override
    public Map<String, String> getCustomOrderAttributes(OrderLine orderLine) {
        EticketOrderLineAbility ability = new EticketOrderLineAbility(buildPreSaleOrderLine(orderLine));
        Boolean supportMultiWriteOff = ability.isVoucherSupportMultiWriteOff();
        Map<String, String> output = Maps.newHashMap();
        output.put("e_multi_write_off", supportMultiWriteOff ? "1" : "0");
        return output;
    }


    private ETicketOrderLine buildPreSaleOrderLine(OrderLine orderLine) {
        ETicketOrderLine eTicketOrderLine = new ETicketOrderLine();
        eTicketOrderLine.setOrderLineId(orderLine.getOrderLineId());
        eTicketOrderLine.setScenario(orderLine.getScenario());
        eTicketOrderLine.setBizCode(orderLine.getBizCode());
        eTicketOrderLine.setItemId(orderLine.getItem().getItemId());
        eTicketOrderLine.setBuyQuantity(orderLine.getBuyQuantity());
        eTicketOrderLine.setUnitPrice(orderLine.getItem().getUnitPrice());
        eTicketOrderLine.getAttributes().putAll(orderLine.getItem().getAttributes());
        eTicketOrderLine.getTags().addAll(orderLine.getItem().getTags());
        return eTicketOrderLine;
    }
}
