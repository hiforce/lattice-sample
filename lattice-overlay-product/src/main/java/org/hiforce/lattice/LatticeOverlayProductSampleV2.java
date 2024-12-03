package org.hiforce.lattice;

import com.google.common.collect.Lists;
import org.hiforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.lattice.sample.ability.OrderLinePriceAbility;
import org.hiforce.lattice.sample.model.OrderLine;
import org.hiforce.lattice.scenario.BuyScenarioRequest;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/23
 */
public class LatticeOverlayProductSampleV2 {

    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();

        System.out.println("---------------------------------------");
        doBusiness("business.b", "groupBuy");
        System.out.println("---------------------------------------");
    }

    public static String doBusiness(String bizCode, String source) {
        StringBuffer buffer = new StringBuffer();
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setUnitPrice(1000L);
        orderLine1.setBizCode(bizCode);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setUnitPrice(2000L);
        orderLine2.setBizCode(bizCode);

        List<OrderLine> orderLines = Lists.newArrayList(
                orderLine1, orderLine2
        );
        try {
            new BizSessionScope<Void, OrderLine>(orderLines) {
                boolean flag = true;

                @Override
                @SuppressWarnings("all")
                protected Void execute() throws LatticeRuntimeException {
                    for (OrderLine orderLine : orderLines) {
                        //bla.bla.bla
                        OrderLinePriceAbility ability = new OrderLinePriceAbility(orderLine);
                        Long unitPrice = ability.getCustomUnitPrice(orderLine);
                        System.out.println(String.format("[%s] overlay product unit price: %s ", bizCode, unitPrice));
                    }
                    return null;
                }

                @Override
                @SuppressWarnings("all")
                public BuyScenarioRequest buildScenarioRequest(OrderLine bizObject) {
                    BuyScenarioRequest request = new BuyScenarioRequest(bizObject);
                    if (flag) {
                        request.setSource(source);
                        flag = false;
                    }
                    //add some other info.
                    return request;
                }
            }.invoke();
            return buffer.toString();
        } catch (LatticeRuntimeException ex) {
            System.out.println(ex.getErrorMessage().getText());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
