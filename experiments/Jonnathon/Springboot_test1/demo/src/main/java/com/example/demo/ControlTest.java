package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
class ControlTest {

    @GetMapping("/")
    public String welcome() {
        return "If you can see this it works";
    }
}

