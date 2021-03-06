package dev.pushparaj.sorting;

import java.util.*;

public class BubbleSort {

    public static void sort(int[] arr) {

        for(int i = arr.length - 1; i > 0; i--) {

            boolean isAlreadySorted = true;
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    isAlreadySorted = false;
                }
            }
            if(isAlreadySorted) return;
            
        }
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}