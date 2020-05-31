package com.wq.design.singleton;

/**
 * 最常用
 */
public class SingletonSimple {
    private final static SingletonSimple INSTANCE= new SingletonSimple();
    private SingletonSimple(){

    }

    public static SingletonSimple getInstance(){
        return INSTANCE;
    }
}
