package com.example.demo.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void spyArrayList(){

        List<String> spyList = spy(ArrayList.class);
        when(spyList.size()).thenReturn(5);
        spyList.add("Vivek");
        assertEquals(5,spyList.size());
        assertEquals("Vivek", spyList.get(0));
    }
}
