package com.wq.algorithm.sort.class3;

import java.util.Arrays;

public class Code01_MergeSort {

    // 递归
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        // 注意+的优先级大于>>
        // 这里之前也写错了，R-L+1了注意
        int mid = L + ((R - L) >> 1);
        process1(arr, L, mid);
        process1(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int p1 = L;
        int p2 = mid + 1;
        int tempIndex = 0;
        int[] tempArr = new int[R - L + 1];
        while (p1 <= mid && p2 <= R) {
            tempArr[tempIndex++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tempArr[tempIndex++] = arr[p1++];
        }
        while (p2 <= R) {
            tempArr[tempIndex++] = arr[p2++];
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[L + i] = tempArr[i];
        }

    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N - 1) {
                int M = L + mergeSize - 1;
                if (M >= N - 1) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int)((maxSize+1)*Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int testTime = 1;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            Arrays.sort(arr1);
//            mergeSort1(arr2);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                succeed = false;
                break;
            }
        }
        if (succeed) {
            System.out.println("success");
        }
    }
}
