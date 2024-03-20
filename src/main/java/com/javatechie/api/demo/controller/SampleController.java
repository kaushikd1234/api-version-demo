package com.javatechie.api.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping(value = "/test", produces = {"application/api.version1.json"})
    public String getMessageVersion1() {
        return "version 1 of the API";
    }

    @GetMapping(value = "/test", produces = {"application/api.version2.json"})
    public String getMessageVersion2() {
        return "version 2 of the API";
    }
}
