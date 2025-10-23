package com.directi.training.lsp.exercise_refactored;

public class NormalDuck extends Duck {
    public NormalDuck() {
        super(null); // Pas de Power pour un canard normal
    }

    @Override
    public void quack() {
        System.out.println("Quack...");
    }

    @Override
    public void swim() {
        System.out.println("Swim...");
    }
}
