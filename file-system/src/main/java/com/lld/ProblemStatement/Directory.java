package com.lld.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectList; // here we don't know what type of object is going to added

    public Directory(String name) {
        this.directoryName = name;
        this.objectList = new ArrayList<>();
    }

    public void add(Object object) {
        objectList.add(object);
    }

    public void ls() {
        System.out.println("Directory name: " + directoryName);

        for(Object obj : objectList) {
            // here we're checking each object is what type, 
            // what we do if we have more that 100 / 1000 types then it's not correct way to write that much if else statements.
            if(obj instanceof File) { 
                ((File) obj).ls();
            } else if(obj instanceof Directory) {
                ((Directory) obj).ls();
            }
        }
    }
}
