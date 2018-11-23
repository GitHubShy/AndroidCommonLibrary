package com.common.shy.interviewmodule.algorithms;

import java.util.ArrayList;

/**
 * There is a pair of rabbits which can propagate in three age and their children also can propagate in three age.
 * The question is that how many rabbits could we have in the X month?
 *
 */
public class Rabbits {

    private ArrayList<Rabbit> mAllRabbits = new ArrayList<>();

    private ArrayList<Rabbit> mNewRabbits = new ArrayList<>();

    public Rabbits() {
        mAllRabbits.add(new Rabbit());
    }

    private void propagating (int months) {
        for (int i = 1 ; i <= months ; i++) {
            for (Rabbit rabbit : mAllRabbits) {
                rabbit.age = rabbit.age + 1;
                if (rabbit.age >= 3) {
                    rabbit.canPropagate = true;
                    Rabbit newRabbit = new Rabbit();
                    newRabbit.age = 1;
                    mNewRabbits.add(newRabbit);
                    rabbit.childCount++;
                }
            }
            mAllRabbits.addAll(mNewRabbits);
            mNewRabbits.clear();
            System.out.println(mAllRabbits.size());
        }
    }

    public static void main(String[] args) {
        new Rabbits().propagating(15);
    }

    class Rabbit {
        int age;
        boolean canPropagate;
        int childCount;
    }
}
