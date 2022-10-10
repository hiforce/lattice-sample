package org.hiforce.lattice.sample.usecase.presale.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.sample.domain.order.ability.ext.BlankOrderLineSaveExt;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;
import org.hiforce.lattice.sample.usecase.presale.PreSaleTradeUseCase;
import org.hiforce.lattice.sample.usecase.presale.ability.PreSaleOrderLineAbility;
import org.hiforce.lattice.sample.usecase.presale.model.PreSaleOrderLine;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Realization(codes = PreSaleTradeUseCase.CODE)
public class PreSaleTradeBusinessExt extends BlankOrderLineSaveExt {
    @Override
    public BigDecimal getItemCustomUnitPrice(OrderLine orderLine) {
        PreSaleOrderLineAbility ability = new PreSaleOrderLineAbility(buildPreSaleOrderLine(orderLine));
        BigDecimal ratio = ability.getCustomDownPaymentRatio();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("[UseCase]PreSaleTrade load custom down payment ratio: " + df.format(ratio));
        return new BigDecimal(orderLine.getItem().getUnitPrice()).multiply(ratio);
    }

    private PreSaleOrderLine buildPreSaleOrderLine(OrderLine orderLine) {
        PreSaleOrderLine preSaleOrderLine = new PreSaleOrderLine();
        preSaleOrderLine.setOrderLineId(orderLine.getOrderLineId());
        preSaleOrderLine.setScenario(orderLine.getScenario());
        preSaleOrderLine.setBizCode(orderLine.getBizCode());
        preSaleOrderLine.setItemId(orderLine.getItem().getItemId());
        preSaleOrderLine.setBuyQuantity(orderLine.getBuyQuantity());
        preSaleOrderLine.setUnitPrice(orderLine.getItem().getUnitPrice());
        preSaleOrderLine.getAttributes().putAll(orderLine.getItem().getAttributes());
        preSaleOrderLine.getTags().addAll(orderLine.getItem().getTags());
        return preSaleOrderLine;
    }
}
