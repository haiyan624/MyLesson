package com.wq.algorithm.sort.selection;

import com.wq.algorithm.sort.ArrUtil;

import java.util.Arrays;

/**
 * 选择排序，每次找到最小的值进行交换
 * 不稳定排序：有两个相等的数，但是不是最小的，有可能前面的数会被交换到后面，所以不稳定例如 3,3,1。第一个三会直接和1交换，排到第二个后面
 * 时间复杂度：n^2
 * 空间复杂度：1
 * 不稳定
 * 优化：第一轮循环，应为len-1，因为第二轮循环会从i+1开始
 */
public class Code03_SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 7, 3, 2, 6, 4, 1, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPosition] > arr[j]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                ArrUtil.swap(arr, i, minPosition);
            }
        }
    }
}
