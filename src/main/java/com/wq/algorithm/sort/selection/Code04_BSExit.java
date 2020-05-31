package com.wq.algorithm.sort.selection;

/**
 * 查找
 */
public class Code04_BSExit {

    public static int isExit(int[] arr, int num) {

        if (arr == null || arr.length < 1) {
            return -1;
        }

        int right = arr.length - 1;
        int left = 0;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr[left] == num ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9, 10};
        System.out.println(Code04_BSExit.isExit(arr, 3));
    }
}
