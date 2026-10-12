package com.lld.ProblemStatement;

public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movie");

        File border = new File("Border");
        movieDirectory.add(border);

        Directory comedyDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyDirectory.add(hulchul);
        movieDirectory.add(comedyDirectory);

        movieDirectory.ls();
    }
}
