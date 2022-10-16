package org.hiforce.lattice.dynamic.web;

import lombok.extern.slf4j.Slf4j;
import org.hiforce.lattice.dynamic.LatticeDynamic;
import org.hiforce.lattice.dynamic.model.PluginFileInfo;
import org.hiforce.lattice.dynamic.product.SampleProduct;
import org.hiforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.lattice.sample.SampleItemAbility;
import org.hiforce.lattice.sample.model.SampleItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;

/**
 * @author Rocky Yu
 * @since 2022/10/10
 */
@Slf4j
@RestController
public class DynamicLoadTestController {

    private static int count = 0;

    @RequestMapping("/clear")
    public String clear() {
        for (PluginFileInfo pluginFileInfo : LatticeDynamic.getInstance().getCurrentFiles()) {
            LatticeDynamic.getInstance().uninstallPlugin(pluginFileInfo.getId());
        }
        return "ok";
    }

    @RequestMapping("/product/install")
    public String installProduct() {
        log.info("====> Test product install");
        clear();
        StringBuilder buffer = new StringBuilder();
        String value =  installBusinessPlugin();
        buffer.append("Before product install:").append(value).append("</br>");

        String urlStr = "/apps/lattice-dynamic-product-1.0.0-SNAPSHOT.jar";
        URL url = DynamicLoadTestController.class.getResource(urlStr);
        if (null != url) {
            File file = new File(url.getPath());
            LatticeDynamic.getInstance().installPlugin(new PluginFileInfo(file));
        }
        value = invokeBusinessPlugin();
        buffer.append("After product install:").append(value);
        return buffer.toString();
    }

    @RequestMapping("/switch-product")
    public String switchProduct() {
        SampleProduct.sampleProductSwitch = !SampleProduct.sampleProductSwitch;
        return "ok";
    }

    @RequestMapping("/business/install")
    public String installBusinessPlugin() {
        clear();

        int mod = count++ % 2;
        String urlStr = "/apps/lattice-business-cloth-1.0.0-SNAPSHOT.jar";
        if (mod == 1) {
            urlStr = "/apps/lattice-business-cloth-1.0.1-SNAPSHOT.jar";
        }
        URL url = DynamicLoadTestController.class.getResource(urlStr);
        if (null != url) {
            File file = new File(url.getPath());
            LatticeDynamic.getInstance().installPlugin(new PluginFileInfo(file));
        }
        return invokeBusinessPlugin();
    }

    @RequestMapping("/business/install/1")
    public String installBusinessPlugin_1() {
        clear();
        String urlStr = "/apps/lattice-business-cloth-1.0.0-SNAPSHOT.jar";
        URL url = DynamicLoadTestController.class.getResource(urlStr);
        if (null != url) {
            File file = new File(url.getPath());
            LatticeDynamic.getInstance().installPlugin(new PluginFileInfo(file));
        }
        return invokeBusinessPlugin();
    }

    @RequestMapping("/business/install/2")
    public String installBusinessPlugin_2() {
        clear();
        String urlStr = "/apps/lattice-business-cloth-1.0.1-SNAPSHOT.jar";
        URL url = DynamicLoadTestController.class.getResource(urlStr);
        if (null != url) {
            File file = new File(url.getPath());
            LatticeDynamic.getInstance().installPlugin(new PluginFileInfo(file));
        }
        return invokeBusinessPlugin();
    }

    @RequestMapping("/invoke")
    public String invokeBusinessPlugin() {

        try {
            SampleItem item = new SampleItem();
            item.setBizCode("business.cloth");

            Long itemPrice = new BizSessionScope<Long, SampleItem>(item) {
                @Override
                @SuppressWarnings("all")
                protected Long execute() throws LatticeRuntimeException {
                    //bla.bla.bla
                    SampleItemAbility ability = new SampleItemAbility(item);
                    return ability.getCustomItemPrice();
                }

                @Override
                @SuppressWarnings("all")
                public ScenarioRequest buildScenarioRequest(SampleItem bizObject) {
                    return new ScenarioRequest() {

                        @Override
                        public IBizObject getBizObject() {
                            return item;
                        }
                    };
                }
            }.invoke();
            return "[Business Cloth] item price: " + itemPrice;
        } catch (LatticeRuntimeException ex) {
            System.out.println(ex.getErrorMessage().getText());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "failed";
    }

    @RequestMapping("/reload")
    public String reload() {
        Lattice.getInstance().reload();
        return "ok";
    }

    @RequestMapping("/uninstall")
    public String uninstall() {
        for (PluginFileInfo pluginFileInfo : LatticeDynamic.getInstance().getCurrentFiles()) {
            LatticeDynamic.getInstance().uninstallPlugin(pluginFileInfo.getId());
        }
        return "ok";
    }
}
