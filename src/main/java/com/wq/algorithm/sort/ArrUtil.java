package com.wq.algorithm.sort;

public class ArrUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }


}
