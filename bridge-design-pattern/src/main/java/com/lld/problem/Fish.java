package com.lld.problem;

public class Fish extends LivingThing {
    @Override
    public void breathe() {
        System.out.println("Fish: Breathes through gills; Lives in water; Respiratory system: Gills");
        System.out.println("Breathing Process: Inhales Oxygen from the water and Exhales Carbon Dioxide.");
    }
}
