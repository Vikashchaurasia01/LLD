package com.lld.Solution1withcompositeDesign;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystems;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystems = new ArrayList<>();
    }

    public void add(FileSystem border) {
        fileSystems.add(border);
    }

    public void ls(){
        System.out.println("Directory name: " + directoryName);

        for(FileSystem obj : fileSystems) {
            obj.ls();
        }
    }
}
