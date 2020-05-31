package com.wq.design.singleton;

/**
 *静态内部类的使用
 */
public class SingletonInner {

    private SingletonInner(){

    }

    private static class SingletonHolder{
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    public static SingletonInner getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
