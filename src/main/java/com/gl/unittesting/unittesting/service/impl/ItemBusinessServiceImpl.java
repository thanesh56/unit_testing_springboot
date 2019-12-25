package com.gl.unittesting.unittesting.service.impl;

import com.gl.unittesting.unittesting.model.Item;
import com.gl.unittesting.unittesting.service.ItemBusinessService;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {


    @Override
    public Item retrieveItem() {
        return new Item(1,"Push Ball",300,3);
    }
}
