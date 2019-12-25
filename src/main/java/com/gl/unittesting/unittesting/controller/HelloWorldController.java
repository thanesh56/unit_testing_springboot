package com.gl.unittesting.unittesting.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        log.info("hello world method of HelloWorldController called");
        return "Hello World";
    }


}
