package org.hiforce.lattice.sample;

import lombok.extern.slf4j.Slf4j;
import org.hifforce.lattice.model.config.BusinessConfig;
import org.hifforce.lattice.model.config.ExtPriority;
import org.hifforce.lattice.model.config.ProductConfig;
import org.hifforce.lattice.model.config.builder.BusinessConfigBuilder;
import org.hifforce.lattice.model.config.builder.PriorityConfigBuilder;
import org.hiforce.lattice.LatticeOverlayProductSample;
import org.hiforce.lattice.product.GroupBuyProduct;
import org.hiforce.lattice.runtime.Lattice;

import static org.hifforce.lattice.model.business.TemplateType.BUSINESS;
import static org.hifforce.lattice.model.business.TemplateType.PRODUCT;
import static org.hiforce.lattice.sample.ability.ext.OrderLinePriceExt.EXT_ORDER_LINE_CUSTOM_UNIT_PRICE;

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
        return BusinessConfigBuilder.builder()
                .bizCode("business.b")
                .install(GroupBuyProduct.CODE)
                .extension
                        (PriorityConfigBuilder.builder()
                                .extCode(EXT_ORDER_LINE_CUSTOM_UNIT_PRICE)
                                .priority(ExtPriority.of(GroupBuyProduct.CODE, PRODUCT))
                                .priority(ExtPriority.of("business.b", BUSINESS))
                                .build()
                        )
                .build();
    }
}
