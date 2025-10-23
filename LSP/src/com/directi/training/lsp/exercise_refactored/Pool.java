package com.directi.training.lsp.exercise_refactored;

public class Pool {
    public void run() {
        Duck normalDuck = new NormalDuck();

        Power electronicPower = new Power();
        electronicPower.turnOn();
        Duck electronicDuck = new ElectronicDuck(electronicPower);

        quack(normalDuck, electronicDuck);
        swim(normalDuck, electronicDuck);
    }

    private void quack(Duck... ducks) {
        for (Duck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(Duck... ducks) {
        for (Duck duck : ducks) {
            duck.swim();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.run();
    }
}
