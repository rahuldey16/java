package com.tutorial.java8.defaultandstatic;

import java.util.List;

public interface Multiplier {

    public int multiply(List<Integer> items);

    default int size(List<Integer> items) {
        return items.size();
    }

    static boolean isEmpty(List<Integer> items) {
        return items.isEmpty();
    }
}
