package com.gl.unittesting.unittesting.service.impl;

import com.gl.unittesting.unittesting.model.Item;
import com.gl.unittesting.unittesting.repository.ItemRepository;
import com.gl.unittesting.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item retrieveItem() {
        return new Item(1,"Push Ball",300,3);

    }

    @Override
    public List<Item> retrieveAllItem() {
        List<Item> items = itemRepository.findAll();
        for(Item item:items){
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }
}
