package org.hiforce.lattice.sample;

import com.google.common.collect.Maps;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.sample.ability.LogisticsAbility;
import org.hiforce.lattice.sample.model.OrderLine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2023/1/28
 */
public class MultiAbilityInstStart {

    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();

        Map<String, String> attributes = Maps.newHashMap();
        attributes.put( "lg_normal", "true"); //只有普通配送方式的能力实例生效
        doInvoke(attributes);
        attributes.put( "lg_offline", "true");//追加线下自提配送方式的能力实例生效
        doInvoke(attributes);
    }

    private static void doInvoke( Map<String, String > attributes){
        System.out.println("--------------------------------------------");
        OrderLine orderLine = new OrderLine();
        orderLine.setUnitPrice(1000L);
        orderLine.setBizCode("cloth");
        orderLine.getAttributes().putAll(attributes);

        List<LogisticsAbility> abilities = Lattice.getAllAbilities(LogisticsAbility.class, orderLine);
        System.out.println("Available Logistic Type: " + abilities.stream().map(LogisticsAbility::getName).collect(Collectors.joining(",")));

        for (LogisticsAbility ability : abilities) {
            Long postFee = ability.getPostFee();
            System.out.println("==>" + ability.getName() + " PostFee:" + postFee);
        }
    }
}
