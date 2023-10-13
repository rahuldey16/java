package com.tutorial.java8.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOp {
    static UnaryOperator<String> unary = s -> s.concat("_Java");
    static BinaryOperator<Integer> binary = (a,b) -> a*b;
    static Comparator<Integer> comp = (a, b) -> a.compareTo(b);
    public static void main(String[] args) {
        System.out.println(unary.apply("Hello"));
        System.out.println(binary.apply(2,3));
        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comp);
        System.out.println(minBy.apply(5,10));
    }
}
