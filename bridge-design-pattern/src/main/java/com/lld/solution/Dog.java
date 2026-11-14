package com.lld.solution;

public class Dog extends LivingThings {
    public Dog(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breathe() {
        System.out.println("Dog: ");
        breathingProcess.breathe(); // Operation implemented by Implementor - defines the "HOW"
    }
}
