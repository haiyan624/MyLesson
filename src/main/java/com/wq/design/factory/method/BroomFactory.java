package com.wq.design.factory.method;

public class BroomFactory {
    public Moveable create(){
        return new Broom();
    }
}
