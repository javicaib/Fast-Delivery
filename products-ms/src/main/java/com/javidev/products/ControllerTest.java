package com.javidev.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @GetMapping
    public String test() {
        return "test";
    }
}
