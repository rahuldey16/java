package com.tutorial.java8.defaultandstatic;

import java.util.List;

public class MultiplierImpl implements Multiplier {

    @Override
    public int multiply(List<Integer> items) {
        return items.stream().reduce(1, (x, y) -> x * y);
    }

    @Override
    public int size(List<Integer> items) {
        System.out.println("Inside MultiplierImpl size()");
        return items.size();
    }
}
