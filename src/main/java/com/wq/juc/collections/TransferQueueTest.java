package com.wq.juc.collections;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueTest {

    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D", "E", "F"};
        int[] nums = {1, 2, 3, 4, 5, 6};


        TransferQueue<String> transfer = new LinkedTransferQueue<>();
//        SynchronousQueue<String> transfer = new SynchronousQueue<>();
        new Thread(() -> {
            for (String s : letters) {
                System.out.print(s);
                try {
                    transfer.put("----s---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int num : nums) {
                try {
                    transfer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(num + "");
            }
        }).start();

    }

}
