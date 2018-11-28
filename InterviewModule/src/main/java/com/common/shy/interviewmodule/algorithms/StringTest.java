package com.common.shy.interviewmodule.algorithms;

public class StringTest {
    public static void main(String[] args) {
        new StringTest().reverseString("1234");
    }

    private void reverseString(String text) {
        byte[] bytes = text.getBytes();
        int length = bytes.length - 1;
        int half = length / 2;
        byte aByte;
        for (int i = 0; i <= half; i++) {
            aByte = bytes[i];
            bytes[i] = bytes[length - i];
            bytes[length - i] = aByte;
        }
        System.out.println("string=" + new String(bytes));
    }
}
