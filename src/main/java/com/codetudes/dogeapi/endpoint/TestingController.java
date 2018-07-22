package com.codetudes.dogeapi.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestingController {
    @GetMapping("2")
    public String test1() {
        return "Hello World!";
    }
}
