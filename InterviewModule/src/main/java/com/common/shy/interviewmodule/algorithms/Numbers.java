package com.common.shy.interviewmodule.algorithms;

public class Numbers {

    public static void main(String[] args) {
//        new Numbers().echoPrimeNumbers();
//        new Numbers().echoNarcissusNumbers(1000);
//        new Numbers().ball(100, 10);
//        new Numbers().calculateFactorial(5);
//        new Numbers().combinationsForNumbers();
        new Numbers().matrix();
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
            System.out.println("i=" + i + "---bounce = " + bounce + "--totalTravel=" + totalTravel);
        }
    }

    /**
     * calculate the factorial
     *
     * @param n
     */
    private int calculateFactorial(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = n * calculateFactorial(n - 1);
        System.out.println("result=" + result);
        return result;
    }

    /**
     * There are four numbers and they are 1,2,3,4 respectively.How many combinations of three-digit numbers in which every one have no
     * repeated numbers from them?
     *
     * @return
     */
    private void combinationsForNumbers() {
        int num = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i != j && j != k && i != k) {
                        num++;
                    }
                }
            }
        }
        System.out.println("numbers=" + num);
    }

    private void matrix() {
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.println(arr[i][j]);
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
