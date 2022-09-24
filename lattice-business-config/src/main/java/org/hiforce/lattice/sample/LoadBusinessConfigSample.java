package org.hiforce.lattice.sample;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.hifforce.lattice.model.business.TemplateType;
import org.hifforce.lattice.model.config.BusinessConfig;
import org.hifforce.lattice.model.config.ExtPriority;
import org.hifforce.lattice.model.config.ProductConfig;
import org.hifforce.lattice.model.config.builder.PriorityConfigBuilder;
import org.hiforce.lattice.LatticeOverlayProductSample;
import org.hiforce.lattice.runtime.Lattice;

/**
 * @author Rocky Yu
 * @since 2022/9/24
 */
@Slf4j
public class LoadBusinessConfigSample {

    public static void main(String[] args) {
        Lattice.getInstance().start();

        Lattice.getInstance().addBusinessConfig(buildBusinessBConfig());//register business configuration.

        System.out.println("---------------------------------------");
        LatticeOverlayProductSample.doBusiness("groupBy");
        System.out.println("---------------------------------------");
    }

    private static BusinessConfig buildBusinessBConfig() {
        return BusinessConfig.builder()
                .bizCode("business.b")
                .installedProducts(Lists.newArrayList(
                        ProductConfig.builder()
                                .code("lattice.productGroupBuyProduct")
                                .build()
                ))
                .priorityConfigs(Lists.newArrayList(
                        PriorityConfigBuilder.builder()
                                .extCode("OrderLinePriceExt.EXT_ORDER_LINE_CUSTOM_UNIT_PRICE")
                                .priority(ExtPriority.of("lattice.productGroupBuyProduct", TemplateType.PRODUCT))
                                .priority(ExtPriority.of("business.b", TemplateType.BUSINESS))
                                .build()
                ))
                .build();
    }
}
