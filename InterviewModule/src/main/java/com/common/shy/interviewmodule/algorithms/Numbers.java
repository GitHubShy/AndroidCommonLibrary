package com.common.shy.interviewmodule.algorithms;

public class Numbers {

    public static void main(String[] args) {
//        new Numbers().echoPrimeNumbers();
//        new Numbers().echoNarcissusNumbers(1000);
        new Numbers().ball(100,10);
    }

    /**
     * How many prime number between 101 and 200 ?
     */
    private void echoPrimeNumbers() {
        for (int i = 101; i < 201; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0 && i != j) {
                    break;
                } else if (i == j) {
                    System.out.println("i=" + i);
                }
            }
        }
    }

    /**
     * How many Narcissus-Numbers within number x?
     */
    private void echoNarcissusNumbers(int num) {
        for (int i = 1; i <= num; i++) {
            int a1 = i % 10;
            int a2 = (i % 100) / 10;
            int a3 = i / 100;
            if (i == (a1 * a1 * a1) + (a2 * a2 * a2) + (a3 * a3 * a3)) {
                System.out.println("i=" + i);
            }
        }
    }

    /**
     * A ball can bounce back to the half of height of where it stayed last time, so how long does the ball travel and what is the
     * height at its the ten times?
     */
    private void ball(int meters, int times) {
        double totalTravel = 0;
        double bounce = meters;
        for (int i = 1; i <= times; i++) {
            bounce = bounce / 2;
            totalTravel = totalTravel + bounce * 3;
            System.out.println("i="+i+"---bounce = " + bounce+"--totalTravel="+totalTravel);
        }
    }
}
