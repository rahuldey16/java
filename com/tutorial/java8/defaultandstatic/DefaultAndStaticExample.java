package com.tutorial.java8.defaultandstatic;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultAndStaticExample {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("one", "two", "three", "four", "five");
        strList.sort(Comparator.naturalOrder());
        System.out.println(strList);
        strList.sort(Comparator.reverseOrder());
        System.out.println(strList);

        StudentDataBase.getAllStudents().stream().sorted(Comparator.nullsFirst(Comparator.comparing(Student::getGradeLevel).thenComparing(Student::getName))).forEach(System.out::println);

        System.out.println("#### Multiplier examples ####");
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println("Multiply: " + multiplier.multiply(integers));
        System.out.println("Size: " + multiplier.size(integers));
        System.out.println("IsEmpty: " + Multiplier.isEmpty(integers));
    }
}
