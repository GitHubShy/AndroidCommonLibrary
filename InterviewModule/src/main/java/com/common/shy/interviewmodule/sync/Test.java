package com.common.shy.interviewmodule.sync;

public class Test {

    int num = 0;

    private  synchronized void add(int b) {
        num = b;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num="+num+"==="+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final Test a = new Test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.add(5);
                for (int i = 0 ; i < 10;i++) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.add(4);
                for (int i = 0 ; i < 10;i++) {
                }
            }
        });
        t1.start();
        t2.start();
    }

}
