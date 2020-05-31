package com.wq.design.factory.abstract1;

public class MagicFactory extends AbstractFactory {
    Food getFood() {
        return new MushRoom();
    }

    Vehicle getVehicle() {
        return new Broom();
    }

    Weapon getWeapon() {
        return new MagicStick();
    }
}
