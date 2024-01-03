package com.tutorial.java8.stream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        /*
            Calculate time difference between sequential and parallel stream
         */
//        System.out.println(Runtime.getRuntime().availableProcessors());
        Supplier<Integer> seqSup = () -> IntStream.rangeClosed(1, 100000).sum();
        Supplier<Integer> parSup = () -> IntStream.rangeClosed(1, 100000).parallel().sum();
        System.out.println("Seq: " + calculateTime(seqSup, 30));
        System.out.println("Parallel: " + calculateTime(parSup, 30));

    }

    private static long calculateTime(Supplier<Integer> sup, int n) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) sup.get();
        return System.currentTimeMillis() - startTime;
    }
}
