package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;

public class HamcrestTest {

    @Test
    public void testHamCrestLibrary(){

        List<Integer> list = List.of(1,2,3);
       // assertThat(list, Matchers.contains(1,2,3));
        assertThat(list, Matchers.containsInAnyOrder(1,3,2));
    }
}
