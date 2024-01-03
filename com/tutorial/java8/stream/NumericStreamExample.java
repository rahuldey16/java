package com.tutorial.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {
    public static void main(String[] args) {
        System.out.println("#### Intstream range ####");
        System.out.println("Sum : " + IntStream.range(1, 10).sum());
        System.out.println("Count :"+ IntStream.range(1, 10).count());

        System.out.println("#### Intstream rangeClosed ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).sum());
        System.out.println("Count :"+ IntStream.rangeClosed(1, 10).count());

        System.out.println("#### LongStream rangeClosed ####");
        System.out.println("Sum : " + LongStream.rangeClosed(1, 10).sum());

        System.out.println("#### DoubleStream rangeClosed ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).asDoubleStream().sum());

        System.out.println("#### Max ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).max());

        System.out.println("#### Min ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).min());

        System.out.println("#### Min ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).average());

        System.out.println("#### Boxed ####");
        System.out.println("Sum : " + IntStream.rangeClosed(1, 10).boxed().toList());
        /*
             read further mapToInt, mapToDouble, mapToObj, etc.
         */
    }
}
