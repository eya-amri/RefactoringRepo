package com.directi.training.lsp.exercise_refactored;

public class Power {
    private boolean on = false;

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
