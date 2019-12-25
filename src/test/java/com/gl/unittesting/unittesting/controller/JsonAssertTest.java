package com.gl.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Push Ball\",\"price\":300,\"quantity\":3}";

    @Test
    public void jsonAssert_StrictTrue() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Push Ball\",\"price\":300,\"quantity\":3}";

        JSONAssert.assertEquals(expectedResponse,actualResponse,true); //if true then we can not skip some content in expected result

    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Push Ball\",\"price\":300}";

        JSONAssert.assertEquals(expectedResponse,actualResponse,false); //if false then we can skip some content in expected result not actual result

    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:\"Push Ball\",price:300}";

        JSONAssert.assertEquals(expectedResponse,actualResponse,false); //if false then we can skip some content in expected result not actual result

    }
}
