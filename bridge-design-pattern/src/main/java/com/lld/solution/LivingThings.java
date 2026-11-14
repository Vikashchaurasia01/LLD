package com.lld.solution;

public abstract class LivingThings {
    // Reference to Implementor
    protected BreathingProcess breathingProcess;

    // Bridge Connects animal and trees with breathing process
    public LivingThings(BreathingProcess breathingProcess) {
        this.breathingProcess = breathingProcess;
    }

    // operation implemented by implementor
    public abstract void breathe();
}
