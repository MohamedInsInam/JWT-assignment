package com.finance.lendo.platform.jwtdemo.controller.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secured")
public class SecuredController {

    @GetMapping("/")
    public String welcome() {
        return "this is a secured controller";
    }

}