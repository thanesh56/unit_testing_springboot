package com.gl.unittesting.unittesting.service;

import com.gl.unittesting.unittesting.model.Item;

import java.util.List;

public interface ItemBusinessService {
    Item retrieveItem();

    List<Item> retrieveAllItem();
}
