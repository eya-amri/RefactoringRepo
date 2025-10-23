package com.directi.training.lsp.exercise_refactored;

public class ElectronicDuck extends Duck {
    public ElectronicDuck(Power power) {
        super(power);
    }

    @Override
    public void quack() {
        if (power.isOn()) {
            System.out.println("Electronic duck quack...");
        } else {
            System.out.println("Can't quack when off");
        }
    }

    @Override
    public void swim() {
        if (power.isOn()) {
            System.out.println("Electronic duck swim...");
        } else {
            System.out.println("Can't swim when off");
        }
    }
}
