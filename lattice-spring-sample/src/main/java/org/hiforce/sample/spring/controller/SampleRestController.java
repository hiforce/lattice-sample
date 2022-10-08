package org.hiforce.sample.spring.controller;

import org.hiforce.lattice.sample.LatticeQuickStart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rocky Yu
 * @since 2022/10/8
 */
@RestController
public class SampleRestController {

    @RequestMapping("/invoke")
    public String invokeExtension() {
        return LatticeQuickStart.doBusinessA() + "</BR>" + LatticeQuickStart.doBusinessB();
    }
}
