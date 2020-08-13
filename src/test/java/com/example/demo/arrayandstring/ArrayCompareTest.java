package com.example.demo.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayCompareTest {

    @Test
    public void compareTwoArray(){
        int [] expected = new int[]{3,4,5,12};
        int [] actual = new int[]{12,5,4,3};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTwoArray_OneBeingNull(){
        int [] expected = new int[]{3,4,5,12};
        int [] actual = null;

        assertThrows(NullPointerException.class,() -> Arrays.sort(actual));

    }

    @Test
    public void sort_Array_Performace(){
        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            int [] arr = new int[] {12,3,4};

            for (int i = 0; i <1000000 ; i++) {
                arr[0]=i;
                Arrays.sort(arr);
            }
        });
    }
}
