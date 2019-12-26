package com.gl.unittesting.unittesting.business;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning(){
        String responseFromService = "[{id:1,name:pen,price:10,quantity:5},{id:2,name:book,price:40,quantity:5},{id:3,name:pencil,price:10,quantity:8}]";
        DocumentContext parse = JsonPath.parse(responseFromService);
        int length = parse.read("$.length()");
        assertThat(length).isEqualTo(3);
        System.out.println(parse.read("$..id").toString());

        List<Integer> ids = parse.read("$..id");
        assertThat(ids).containsExactly(1,2,3);

        System.out.println(parse.read("$.[1]").toString());
        System.out.println(parse.read("$.[0:1]").toString());
        System.out.println(parse.read("$.[?(@.name=='pen')]").toString());
        System.out.println(parse.read("$.[?(@.quantity==5)]").toString());

    }
}
