package com.common.shy.interviewmodule.algorithms;

public class PurchaseChickens {

    public static void main(String[] args) {
        new PurchaseChickens().soldiers();
    }

    /**
     * A cock is worth 5, a hen is worth 3, a chick is worth 1. How many possibilities could buy 100
     * chicken by 100?
     */
    private void calculatePossibilities() {
        int cock, hen, chick;
        for (cock = 0; cock <= 20; cock++) {
            for (hen = 0; hen <= 33; hen++) {
                chick = 100 - cock - hen;
                int total = 5 * cock + 3 * hen + chick / 3;
                if (total == 100 && chick % 3 == 0) {
                    System.out.println("cock=" + cock + "hen=" + hen + "chick=" + chick);
                }
            }
        }
    }

    /**
     * 韩信带兵不足百人，3人一行排列多一人，7人一行排列少两人，5人一行正好，本例是计算韩信究竟点了多少兵？
     *
     */
    private void soldiers() {
        for (int i = 0 ; i < 100 ; i++) {
            if (i % 3 == 1 && i % 7 == 5 && i % 5 == 0) {
                System.out.println("i=" +i);
            }
        }

    }
}
