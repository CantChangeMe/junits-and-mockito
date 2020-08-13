package com.example.demo.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArgsVariationsWithMockito {

    @Test
    public void stubMethodWithOneArg(){
        List<Integer> mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2,mockList.size());

    }

    @Test
    public void stubMethodWithTwoCalls(){
        List<Integer> mockList = mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(4);
        assertEquals(2,mockList.size());
        assertEquals(4, mockList.size());

    }

    @Test
    public void stubMethodWithMatchers(){
        List<String> mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("Hi");
        assertEquals("Hi",mockList.get(0));
        assertEquals("Hi",mockList.get(1));
    }

    @Test
    public void stubMethodWithException(){
        List<String> mockList = mock(List.class);
        when(mockList.get(1)).thenThrow(new RuntimeException("Hi"));
        Exception exception =  assertThrows(RuntimeException.class,() -> mockList.get(1));

        assertEquals("Hi",exception.getMessage());
    }


}
