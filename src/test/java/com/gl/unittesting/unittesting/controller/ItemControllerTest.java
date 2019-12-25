package com.gl.unittesting.unittesting.controller;

import com.gl.unittesting.unittesting.model.Item;
import com.gl.unittesting.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemController.class)
@ExtendWith(value = SpringExtension.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    void dummyItem() throws Exception {
        //call Get "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Push Ball\",\"price\":300,\"quantity\":3}"))
                .andReturn();

        //verify the result
        //assertEquals();
    }

    @Test
    void itemFromBusinessService() throws Exception {
        when(itemBusinessService.retrieveItem()).thenReturn(new Item(2,"Pull Ball",500,11));

        //call Get "/item-from-business-service" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2,name:\"Pull Ball\",price:500,quantity:11}"))
                .andReturn();

        //verify the result
        //assertEquals();
    }

    @Test
    void allItemFromDatabase_basic() throws Exception {
        when(itemBusinessService.retrieveAllItem()).thenReturn(
                Arrays.asList( new Item(2,"Pull Ball",500,11),
                               new Item(3,"Push Ball",500,11)
                )
        );

        //call Get "/all-items-from-database" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 2,name:\"Pull Ball\",price:500,quantity:11},{id: 3,name:\"Push Ball\",price:500,quantity:11}]"))
                .andReturn();

    }
}