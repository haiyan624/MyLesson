package com.wq.juc.local;

public class ThreadLocal2<T> extends ThreadLocal<T>{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("aaa");
        super.finalize();
    }
}
