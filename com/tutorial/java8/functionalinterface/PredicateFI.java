package com.tutorial.java8.functionalinterface;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateFI {
    public static void main(String[] args) {
        Predicate<Integer> p1 = i -> i % 2 ==0;
        Predicate<Integer> p2 = i -> i<10;

        System.out.println(p1.test(10));  // true
        System.out.println(p2.test(10));  // false
        System.out.println(p1.and(p2).test(8)); // true
        System.out.println(p1.or(p2).test(8));  // true
        System.out.println(p1.or(p2).negate().test(8));  //false

        Predicate<Student> grade = s -> s.getGradeLevel() >= 3;
        Predicate<Student> gpa = s -> s.getGpa() > 3.5;

        Consumer<Student> studentConsumer = s -> {
            if (grade.and(gpa).test(s)) {
                System.out.println(s.getName() + " " + s.getActivities());
            }
        };

        StudentDataBase.getAllStudents().forEach(studentConsumer);

    }
}
