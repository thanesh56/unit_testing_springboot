package com.gl.unittesting.unittesting.controller;


import com.gl.unittesting.unittesting.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ItemController {

    @GetMapping(value = "/dummy-item")
    public Item dummyItem(){
        log.info("dummyItem method of ItemController called");
        return new Item(1,"Push Ball",300,3);
    }


}
