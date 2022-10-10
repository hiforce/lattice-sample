package org.hiforce.lattice.sample.service.server;

import org.hiforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.lattice.model.business.BusinessTemplate;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.lattice.sample.domain.order.ability.OrderLineSaveAbility;
import org.hiforce.lattice.sample.domain.order.model.OrderLine;
import org.hiforce.lattice.sample.domain.order.model.OrderLineItem;
import org.hiforce.lattice.sample.scenario.buy.request.BuyScenarioRequest;
import org.hiforce.lattice.sample.scenario.buy.result.OrderLineResult;
import org.hiforce.lattice.sample.scenario.buy.result.ShoppingResult;
import org.hiforce.lattice.sample.service.PlaceOrderService;
import org.hiforce.lattice.sample.service.params.PlaceOrderReqDTO;
import org.hiforce.lattice.sample.service.params.PlaceOrderRespDTO;

import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class PlaceOrderServiceServer implements PlaceOrderService {

    @Override
    public PlaceOrderRespDTO createOrder(PlaceOrderReqDTO reqDTO) {

        try {
            ShoppingResult result = new BizSessionScope<ShoppingResult, OrderLine>(buildOrderLine(reqDTO)) {
                @Override
                @SuppressWarnings("all")
                protected ShoppingResult execute() throws LatticeRuntimeException {
                    ShoppingResult shoppingResult = new ShoppingResult();

                    for (OrderLine orderLine : getBizObjects()) {
                        OrderLineResult orderLineResult = new OrderLineResult(orderLine);
                        OrderLineSaveAbility saveAbility = new OrderLineSaveAbility(orderLine);
                        BigDecimal totalPay = saveAbility.calcOrderLinePayPrice();
                        orderLineResult.setTotalPay(totalPay.longValue());
                        orderLineResult.getAttributes().putAll(saveAbility.getCustomOrderAttributes(orderLine));
                        shoppingResult.getOrderLineResults().add(orderLineResult);
                    }

                    doSaveShoppingResultToDB(shoppingResult);
                    return shoppingResult;
                }

                @Override
                @SuppressWarnings("all")
                public BuyScenarioRequest buildScenarioRequest(OrderLine orderLine) {
                    BuyScenarioRequest request = new BuyScenarioRequest();
                    request.setOrderLine(orderLine);
                    request.setScenario(reqDTO.getScenario());
                    request.getRequestParams().putAll(reqDTO.getRequestParams());

                    BusinessTemplate business = Lattice.getInstance().getFirstMatchedBusiness(request);
                    orderLine.setBizCode(business.getCode());
                    return request;
                }
            }.invoke();
        } catch (LatticeRuntimeException ex) {
            System.out.println(ex.getErrorMessage().getText());
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return null;
    }

    private void doSaveShoppingResultToDB(ShoppingResult shoppingResult) {
        //bla...bla...bla...

        shoppingResult.getOrderLineResults().forEach(p -> {
            System.out.printf("Save OrderLine id: %s, bizCode: %s%n", p.getOrderLineId(), p.getBizCode());
            System.out.printf("-- Total Pay Price: %s%n", p.getTotalPay());
            System.out.printf("-- Order Attributes: %s%n", p.getAttributes().entrySet().stream()
                    .map(entry -> String.format("[%s:%s]", entry.getKey(), entry.getValue())).collect(Collectors.joining(",")));
        });
    }

    private OrderLine buildOrderLine(PlaceOrderReqDTO reqDTO) {
        OrderLine orderLine = new OrderLine();
        orderLine.setItem(mockGetItemById(reqDTO.getItemId()));
        orderLine.setScenario(reqDTO.getScenario());
        orderLine.setBuyQuantity(reqDTO.getBuyQuantity());


        return orderLine;
    }

    private OrderLineItem mockGetItemById(long itemId) {

        OrderLineItem item = new OrderLineItem();
        item.setItemId(itemId);
        item.setUnitPrice(10000);
        item.getTags().add(1024);
        item.getTags().add(9527);

        item.getAttributes().put("eticket", "1");
        item.getAttributes().put("presale", "1");
        return item;
    }
}
