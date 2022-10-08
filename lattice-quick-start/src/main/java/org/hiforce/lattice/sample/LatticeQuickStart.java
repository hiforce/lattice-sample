package org.hiforce.lattice.sample;

import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.sample.ability.OrderLinePriceAbility;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 */
public class LatticeQuickStart {

    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();

        doBusinessA();
        doBusinessB();

    }

    public static String doBusinessA() {
        OrderLine orderLine = new OrderLine();
        orderLine.setUnitPrice(1000L);
        orderLine.setBizCode("business.a");
        OrderLinePriceAbility ability = new OrderLinePriceAbility(orderLine);
        Long unitPrice = ability.getCustomUnitPrice(orderLine);
        String result = "[Business A] unit price: " + unitPrice;
        System.out.println(result);
        return result;
    }

    public static String doBusinessB() {
        OrderLine orderLine = new OrderLine();
        orderLine.setUnitPrice(1000L);
        orderLine.setBizCode("business.b");
        OrderLinePriceAbility ability = new OrderLinePriceAbility(orderLine);
        Long unitPrice = ability.getCustomUnitPrice(orderLine);
        String result = "[Business B] unit price: " + unitPrice;
        System.out.println(result);
        return result;
    }
}
