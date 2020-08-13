package com.example.demo.arrayandstring;

import java.util.Arrays;

public class ArraySortRunner {
    public static void main(String[] args) {
        sort();
    }

    public static void sort(){
        int [] arr = new int[] {12,3,4};

        for (int i = 0; i <1000000 ; i++) {
            arr[0]=i;
            Arrays.sort(arr);
        }
    }

}
