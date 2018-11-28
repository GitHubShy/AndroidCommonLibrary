package com.common.shy.interviewmodule.algorithms;

public class Algorithms {
    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        sortAlgorithm.quickSort(0,sortAlgorithm.getmNumbers().length -1);
        sortAlgorithm.echo(sortAlgorithm.getmNumbers());
    }
}
