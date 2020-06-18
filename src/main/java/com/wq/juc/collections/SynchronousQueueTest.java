//package com.wq.juc.collections;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.TimeUnit;
//
//public class SynchronousQueueTest {
//    public static void main(String[] args) throws InterruptedException {
//        final BlockingQueue<String> bQueue = new SynchronousQueue<String>();
//
//        new Thread(() -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(3000);
//                System.out.println(bQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        try {
//            System.out.println("bbb");
//            bQueue.put("aaaa");
//            System.out.println("bbb2");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(bQueue.take());
//
//    }
//}
