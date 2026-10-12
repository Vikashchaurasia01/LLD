package com.lld.Solution1withcompositeDesign;

public class Main {
    public static void main(String[] args) {

        Directory movieDirectory = new Directory("Movie");
        File border = new File("Border");
        movieDirectory.add(border);

        Directory comedyDirectory = new Directory("ComedyMovies");
        File hulchul = new File("Hulchul");
        comedyDirectory.add(hulchul);
        movieDirectory.add(comedyDirectory);

        movieDirectory.ls();
    }
}
