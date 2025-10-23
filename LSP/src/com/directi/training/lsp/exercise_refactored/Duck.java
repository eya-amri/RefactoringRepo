package com.directi.training.lsp.exercise_refactored;

public abstract class Duck {
    protected Power power;

    public Duck(Power power) {
        this.power = power;
    }

    public abstract void quack();

    public abstract void swim();
}
