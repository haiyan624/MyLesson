package com.wq.juc.local;

import java.io.IOException;

public class ThreadLocalTest {
    public static void main(String[] args) throws IOException {

//        System.out.println(t1.get());


//        t1.remove();
//        System.out.println(t1.get());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ThreadLocal2<M> t1 = new ThreadLocal2<M>();
            t1.set(new M());
//            t1.remove();
            t1 = null;
            System.gc();
        }
    }
}
