package org.hiforce.sample.cloth.controller;

import org.hiforce.sample.cloth.bean.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rocky Yu
 * @since 2022/10/17
 */
@RestController
public class ClotController {

    @Autowired
    private ClothService clothService;

    @RequestMapping("/cloth")
    public String cloth() {
        return clothService.helloCloth();
    }
}
