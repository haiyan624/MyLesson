package com.wq.design.factory.method;

public class CarFactory {
    public Moveable create(){
        // do some other
        return new Car();
    }
}
