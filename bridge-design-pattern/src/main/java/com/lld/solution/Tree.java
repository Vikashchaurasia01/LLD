package com.lld.solution;

public class Tree extends LivingThings {
    public Tree(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breathe() {
        System.out.println("Tree: ");
        breathingProcess.breathe(); // Operation implemented by Implementor - defines the "HOW"
    }
    
}
