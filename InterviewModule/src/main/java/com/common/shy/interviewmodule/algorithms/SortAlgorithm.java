package com.common.shy.interviewmodule.algorithm;


public class SortAlgorithm {

    private Integer[] mNumbers = new Integer[]{33, 43, 65, 3, 44, 1, 87, 88, 98, 78, 101, 2, 4, 56};

    public void bubbleSort() {
        int length = mNumbers.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (mNumbers[j] < mNumbers[j - 1]) {
                    temp = mNumbers[j];
                    mNumbers[j] = mNumbers[j - 1];
                    mNumbers[j - 1] = temp;
                }

            }
        }
        echo(mNumbers);
    }

    public void selectSort() {
        int length = mNumbers.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (mNumbers[j] < mNumbers[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                temp = mNumbers[i];
                mNumbers[i] = mNumbers[minimumIndex];
                mNumbers[minimumIndex] = temp;
            }
        }
        echo(mNumbers);
    }

    public void insertionSort() {
        int length = mNumbers.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (mNumbers[j] < mNumbers[j-1]) {
                    temp = mNumbers[j-1];
                    mNumbers[j-1] = mNumbers[j];
                    mNumbers[j] = temp;
                } else {
                    break;
                }
            }
        }
        echo(mNumbers);
    }


    private void echo(Integer[] mNumbers) {
        for (Integer i : mNumbers) {
            System.out.println(i);
        }
    }
}
