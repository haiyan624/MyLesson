package com.wq.algorithm.sort.selection;


public class Code07_EvenTimesOddTimes {

    /**
     * 得到最低位num
     *
     * @param num
     * @return
     */
    public static int getNearOne(int num) {
        return num ^ (~num + 1);
    }

    /**
     * 不利用额外空间交换两个数
     * 但是这两个数不能属于同一空间，即index1与index2不能是同一数组的不同空间
     *
     * @param index1
     * @param index2
     */
    public static void swap(int index1, int index2) {
        System.out.println(index1);
        System.out.println(index2);
        index1 = index1 ^ index2;
        index2 = index1 ^ index2;
        index1 = index1 ^ index2;
        System.out.println(index1);
        System.out.println(index2);
    }

    /**
     * 出现奇数次
     *
     * @param arr
     * @return
     */
    public static int getOddTimeNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
        return eor;
    }

    public static void getOddTimeTwoNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        int temp1 = eor & (~eor + 1);
        int res1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((temp1 & arr[i]) != 0) {
                res1 = res1 ^ arr[i];
            }
        }

        int res2 = eor ^ res1;
        System.out.println(res1);
        System.out.println(res2);
    }

    public static void bit1Count(int num) {
        int count = 0;
        while (num != 0) {
            count++;

            int temp = num & (~num + 1);
            num = num ^ temp;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 3, 22, 3, 2, 5};
//        Code07_EvenTimesOddTimes.getOddTimeTwoNum(arr);
        int num = -1;
        Code07_EvenTimesOddTimes.bit1Count(num);
        System.out.println(Integer.toBinaryString(num));
    }
}
