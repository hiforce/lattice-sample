package org.hiforce.lattice.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rocky Yu
 * @since 2022/10/8
 */
@Configuration
@SpringBootApplication
public class LatticeDynamicStarter {
    public static void main(String[] args) {
        SpringApplication.run(LatticeDynamicStarter.class, args);
    }
}
