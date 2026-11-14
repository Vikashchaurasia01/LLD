package com.lld.problem;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Demonstrating Bridge Design Pattern");
        LivingThing dog = new Dog();
        dog.breathe();
        LivingThing fish = new Fish();
        fish.breathe();
        LivingThing whale = new Whale();
        whale.breathe();
        LivingThing tree = new Tree();
        tree.breathe();
    }
}
