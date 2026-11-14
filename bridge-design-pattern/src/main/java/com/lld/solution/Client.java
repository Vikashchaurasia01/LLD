package com.lld.solution;

public class Client {
    public static void main(String[] args) {
        BreathingProcess lungBreathing = new LungBreathing();
        BreathingProcess gillBreathing = new GillBreathing();
        BreathingProcess photosynthesis = new Photosynthesis();

        LivingThings dog = new Dog(lungBreathing);
        LivingThings fish = new Fish(gillBreathing);
        LivingThings tree = new Tree(photosynthesis);

        dog.breathe(); // Output: Dog: Breathing through lungs
        fish.breathe(); // Output: Fish: Breathing through gills
        tree.breathe(); // Output: Tree: Breathing through photosynthesis
    }
}
