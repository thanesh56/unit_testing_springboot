package com.gl.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = HelloWorldController.class)
@ExtendWith(SpringExtension.class)
//@RunWith(SpringJUnit4ClassRunner.class)//for junit4
class HelloWorldControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        //call Get "/helloworld" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/helloworld").accept(MediaType.APPLICATION_JSON);

        //MvcResult takes the result
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World")) //it also take json etc
                .andReturn();

        //verify the result
        //assertEquals("Hello World",result.getResponse().getContentAsString());

    }
}