package com.wq.design.singleton;

/**
 * 争议最多
 */
public class SingletonDCL {
    private static volatile SingletonDCL INSTANCE;
    private SingletonDCL(){

    }

    public static SingletonDCL getINSTANCE(){
        if(INSTANCE==null){
            synchronized(SingletonDCL.class){
                if(INSTANCE==null){
                    INSTANCE = new SingletonDCL();
                }
            }
        }
        return INSTANCE;
    }
}
