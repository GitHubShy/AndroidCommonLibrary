package com.common.shy.interviewmodule.algorithms;

public class StringTest {
    public static void main(String[] args) {
        new StringTest().reverseString("1234");
        new StringTest().makeComplement("ATTGC");
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

    public static String makeComplement(String dna) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            char c = dna.charAt(i);
            if (c == 'A') {
                sb.append('T');
            }
            if (c == 'T') {
                sb.append('A');
            }
            if (c == 'C') {
                sb.append('G');
            }
            if (c == 'G') {
                sb.append('C');
            }
        }
        return sb.toString();
    }
}
