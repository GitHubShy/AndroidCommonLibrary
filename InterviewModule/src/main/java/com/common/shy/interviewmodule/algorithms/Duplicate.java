package com.common.shy.interviewmodule.algorithms;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * 查找第一个不重复的字母
 */
public class Duplicate {

    private String question = "aadertyuioplkjkhjgfdazxvbnmvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvddcb" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadertyuioplkjkhjgfdazxvaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "b";

    public static void main(String[] args) {
       new Duplicate().get();
    }

    private void get() {
        long l = System.currentTimeMillis();
        HashSet<Character> ts = new HashSet<>();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            char c = question.charAt(i);
            if (ts.add(c)) {
                a.add(String.valueOf(c));
            } else {
                a.remove(String.valueOf(c));
            }
        }
        System.out.println(a.get(0));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
    }
}
