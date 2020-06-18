package com.wq.algorithm.sort.class3;

import java.util.Arrays;

public class Code03_PartitionAndQuickSort {

    /**
     * 荷兰国旗问题：给定arr和左右边界，找出以R为边界，左边都是小于R，右边都是大于R。的起始与终止数组
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] netherLandFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // 左边界
        int more = R; // 右边界
        int index = L;//活动变量
        // 活动变量小于右边界继续
        while (index < more) {
            // 小于时左边界+1 与当前交换，左边界++ 当前++
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] == arr[R]) {
                // 等于 index往下走
                index++;
            } else {
                // 大于时 当前和右边界-1交换，右边界-1,i不动
                swap(arr, --more, index);
            }
        }
        // 交换R和右边界
        swap(arr, R, more);
        return new int[]{less + 1, more};
    }

    // 交换
    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void quickSort1(int[] arr) {
        if (arr == null) {
            return;
        }

        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int partition = partition(arr, L, R);
        process1(arr, L, partition - 1);
        process1(arr, partition + 1, R);
    }

    private static int partition(int[] arr, int L, int R) {
        if (L >= R) {
            return L;
        }

        int less = L - 1;
        int more = R;
        int index = L;
        // 这里犯了个错，写成less < more
//        while (less < more) {
        while (index < more) {
            if (arr[index] <= arr[R]) {
                swap(arr, ++less, index++);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return more;
    }


    public static void quickSort2(int[] arr) {
        if (arr == null) {
            return;
        }

        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] partitionArr = netherLandFlag(arr, L, R);
        process2(arr, L, partitionArr[0] - 1);
        process2(arr, partitionArr[1] + 1, R);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null) {
            return;
        }

        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] partitionArr = netherLandFlag(arr, L, R);
        process2(arr, L, partitionArr[0] - 1);
        process2(arr, partitionArr[1] + 1, R);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i< arr.length; i++){
            arr[i] = (int)((maxValue+1)* Math.random()) - (int)((maxValue+1)*Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        int[] copyArr = new int[arr.length];
        for(int i=0; i< arr.length;i++){
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static void printArr(int[] arr){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1==arr2){
            return true;
        }
        if((arr1==null &&arr2!=null)||(arr1!=null&&arr2==null)){
            return false;
        }
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxSize = 10000;
        int maxValue = 100;
        int testTime = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }
}