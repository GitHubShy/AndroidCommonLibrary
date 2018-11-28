package com.common.shy.interviewmodule.algorithms;


public class SortAlgorithm {

    private Integer[] mNumbers = new Integer[]{5, 1, 4, 6};

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
                if (mNumbers[j] < mNumbers[j - 1]) {
                    temp = mNumbers[j - 1];
                    mNumbers[j - 1] = mNumbers[j];
                    mNumbers[j] = temp;
                } else {
                    break;
                }
            }
        }
        echo(mNumbers);
    }

    public Integer[] getmNumbers() {
        return mNumbers;
    }

    public void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = mNumbers[i];
        while (i < j) {
            while (i < j && mNumbers[j] >= temp) {
                j--;
            }
            if (i < j) {
                mNumbers[i] = mNumbers[j];
            }
            while (i < j && mNumbers[i] <= temp) {
                i++;
            }
            if (i < j) {
                mNumbers[j] = mNumbers[i];
            }
        }
        mNumbers[i] = temp;
        quickSort(0, i - 1);
        quickSort(i + 1, mNumbers.length - 1);

    }


    public void echo(Integer[] mNumbers) {
        for (Integer i : mNumbers) {
            System.out.println(i);
        }
    }
}
