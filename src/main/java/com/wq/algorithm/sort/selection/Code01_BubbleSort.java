package com.wq.algorithm.sort.selection;

import com.wq.algorithm.sort.ArrUtil;

import java.util.Arrays;

public class Code01_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 8, 6, 3, 1, 4};
        Code01_BubbleSort.bubbleSort(arr);
    }
}
