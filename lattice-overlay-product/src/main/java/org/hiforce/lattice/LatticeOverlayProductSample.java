package org.hiforce.lattice;

import org.hifforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.lattice.sample.ability.OrderLinePriceAbility;
import org.hiforce.lattice.sample.model.OrderLine;
import org.hiforce.lattice.scenario.BuyScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/9/23
 */
public class LatticeOverlayProductSample {

    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();

        System.out.println("---------------------------------------");
        doBusiness("business.b", null);
        System.out.println("---------------------------------------");
        doBusiness("business.b", "groupBuy");
        System.out.println("---------------------------------------");
    }

    public static String doBusiness(String bizCode, String source) {
        StringBuffer buffer = new StringBuffer();
        OrderLine orderLine = new OrderLine();
        orderLine.setUnitPrice(1000L);
        orderLine.setBizCode(bizCode);
        try {
            Long unitPrice = new BizSessionScope<Long, OrderLine>(orderLine) {
                @Override
                @SuppressWarnings("all")
                protected Long execute() throws LatticeRuntimeException {
                    //bla.bla.bla
                    OrderLinePriceAbility ability = new OrderLinePriceAbility(orderLine);
                    return ability.getCustomUnitPrice(orderLine);
                }

                @Override
                @SuppressWarnings("all")
                public BuyScenarioRequest buildScenarioRequest(OrderLine bizObject) {
                    BuyScenarioRequest request = new BuyScenarioRequest(bizObject);
                    request.setSource(source);
                    //add some other info.
                    return request;
                }
            }.invoke();
            buffer.append(String.format("[%s] overlay product unit price: %s ", bizCode, unitPrice));
            System.out.println(buffer.toString());
            return buffer.toString();
        } catch (LatticeRuntimeException ex) {
            System.out.println(ex.getErrorMessage().getText());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
