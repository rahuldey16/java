package com.tutorial.java8.functionalinterface;

import com.tutorial.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerFI {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> addition = (a, b) -> System.out.println("Addition of " + a + " + " + b + " = " + (a + b));
        addition.accept(2,3);
        BiConsumer<String, List<String>> studentActivities = (name, activitiesList) -> System.out.println(name + " " + activitiesList);
        StudentDataBase.getAllStudents().forEach(student -> studentActivities.accept(student.getName(),student.getActivities()));
    }
}
