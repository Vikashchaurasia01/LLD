package com.lld.Solution1withcompositeDesign;

public class File implements FileSystem {
    String fileName;

    public File(String name) {
        this.fileName = name;
    }

    public void ls() {
        System.out.println("File name: " + fileName);
    }
}
