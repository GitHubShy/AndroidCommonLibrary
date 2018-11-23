package com.common.shy.interviewmodule.memory;

public class GenerateInstanceChild extends GenerateInstance {

    private static OutClass outClass = new OutClass("GenerateInstanceChild");

    public GenerateInstanceChild(String name) {
        super(name);
        outName = name;
        System.out.println("constructor of child");
    }
}
