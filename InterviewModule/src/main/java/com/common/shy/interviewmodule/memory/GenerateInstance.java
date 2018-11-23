package com.common.shy.interviewmodule.memory;

public class GenerateInstance {

    protected String outName;

    private static OutClass outClass = new OutClass("fromGenerateInstance");

    private static InnerClass innerClass = new InnerClass("inner");


    static {
        System.out.println("static method");
    }

    public GenerateInstance(String name) {
        this.outName = name;
        System.out.println("constructor of GenerateInstance outName="+outName);
    }

    static class InnerClass {

        private String innerName;

        public InnerClass(String innerName) {
            this.innerName = innerName;
            System.out.println("constructor of inner class");
        }
    }
}
