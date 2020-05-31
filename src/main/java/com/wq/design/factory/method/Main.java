package com.wq.design.factory.method;

/**
 * 方法工厂：横向扩展好
 */
public class Main {
    public static void main(String[] args) {
        Moveable car = new CarFactory().create();
        car.go();
    }
}
