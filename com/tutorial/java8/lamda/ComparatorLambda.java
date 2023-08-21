package com.tutorial.java8.lamda;

import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        Comparator<Integer> compInt = (a, b) -> a.compareTo(b);
        System.out.println("Comparing result of 2 and 3 "+compInt.compare(2,3));
    }
}
