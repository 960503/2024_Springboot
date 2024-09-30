package com.example.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/variable")
    public String test(){
        return "test/variable";
    }

    @GetMapping("/condition")
    public String condition(){
        return "test/condition";
    }

}
