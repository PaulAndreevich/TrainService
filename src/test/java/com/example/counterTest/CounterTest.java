package com.example.counterTest;

import com.example.counter.Counter;
import com.example.railway.Train;

public class CounterTest {
    public static void main(String[] args) {

        Train train = null;
        int testValue = 0;
        int failierCounter = 0;

        testValue = 1;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 1 passed!");
        } else {
            System.out.println("Test # 1 failed!");
            failierCounter++;
        }

        testValue = 0;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 2 passed!");
        } else {
            System.out.println("Test # 2 failed!");
            failierCounter++;
        }

        testValue = 10;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 3 passed!");
        } else {
            System.out.println("Test # 3 failed!");
            failierCounter++;
        }

        testValue = 20;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 4 passed!");
        } else {
            System.out.println("Test # 4 failed!");
            failierCounter++;
        }

        testValue = 30;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 5 passed!");
        } else {
            System.out.println("Test # 5 failed!");
            failierCounter++;
        }

        testValue = -2;
        train = new Train(testValue);
        if (0 == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 6 passed!");
        } else {
            System.out.println("Test # 6 failed!");
            failierCounter++;
        }

        testValue = 100;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 7 passed!");
        } else {
            System.out.println("Test # 7 failed!");
            failierCounter++;
        }

        testValue = 1000;
        train = new Train(testValue);
        if (testValue == Counter.findSizeOfTrain(train.getRoot())){
            System.out.println("Test # 8 passed!");
        } else {
            System.out.println("Test # 8 failed!");
            failierCounter++;
        }

        if (failierCounter == 0) {
            System.out.println("\nAll tests passed!");
        } else {
            System.out.println("\nSome tests have failed!");
        }
    }

}
