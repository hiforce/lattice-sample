package org.hiforce.sample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rocky Yu
 * @since 2022/10/8
 */
@Configuration
@SpringBootApplication
public class LatticeSpringSampleStarter {
    public static void main(String[] args) {
        SpringApplication.run(LatticeSpringSampleStarter.class, args);
    }
}
