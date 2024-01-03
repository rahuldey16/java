package com.tutorial.java8.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryExample {
    public static void main(String[] args) {
        System.out.println("#### Stream.of ####");
        Stream.of(1, 2, 3, 4).forEach(System.out::println);

        System.out.println("#### Stream.iterate ####");
        Stream.iterate(1, integer -> integer + integer).limit(10).forEach(System.out::println);

        System.out.println("#### Stream.generate ####");
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);


    }
}
