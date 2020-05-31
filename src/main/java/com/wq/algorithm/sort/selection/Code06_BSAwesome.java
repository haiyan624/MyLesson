package com.wq.algorithm.sort.selection;

/**
 * 无序数组中，任意两个数都不相等
 * 找到任意一个局部最小
 * 局部最小定义：
 * 1. 0位置小于1位置
 * 2. n-1位置小于n-2位置
 * 3. 中间位置比两侧小
 */
public class Code06_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 为局部最小则返回，不是局部最小，则移动
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {10, 0, 5, 2, 4, 3, 11};
        System.out.println(Code06_BSAwesome.getLessIndex(arr));
    }
}
