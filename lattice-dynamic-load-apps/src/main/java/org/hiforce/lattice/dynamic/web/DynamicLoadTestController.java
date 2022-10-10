package org.hiforce.lattice.dynamic.web;

import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.sample.SampleItemAbility;
import org.hiforce.lattice.sample.model.SampleItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
@RestController
public class DynamicLoadTestController {

    @RequestMapping("/invoke")
    public String invokeBusinessPlugin() {
        SampleItem item = new SampleItem();
        item.setBizCode("business.cloth");
        SampleItemAbility ability = new SampleItemAbility(item);
        Long itemPrice = ability.getCustomItemPrice();
        return "[Business Cloth] item price: " + itemPrice;
    }

    @RequestMapping("/reload")
    public String reload() {
        Lattice.getInstance().reload();
        return "ok";
    }
}
