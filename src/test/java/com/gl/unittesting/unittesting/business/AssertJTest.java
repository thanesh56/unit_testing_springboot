package com.gl.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);
//        assertThat(numbers,hasSize(3));
          assertThat(numbers).hasSize(3)
                             .contains(12,45)
                             .allMatch(x->x>10)
                             .allMatch(x->x<100)
                             .noneMatch(x->x<0);

//        assertThat(numbers,hasItems(12,45));
//        assertThat(numbers,everyItem(greaterThan(10)));
//        assertThat(numbers,everyItem(lessThan(100)));
//
//        assertThat("",isEmptyString());
        assertThat("").isEmpty();
        assertThat("ABCD").contains("BCD","ABC")
                                .startsWith("ABC")
                                .endsWith("BCD");
//        assertThat("ABCD",containsString("BCD"));
//        assertThat("ABCD",containsStringIgnoringCase("bcD"));
//        assertThat("ABCD",startsWith("ABC"));
//        assertThat("ABCD",endsWith("Cd"));

    }
}
