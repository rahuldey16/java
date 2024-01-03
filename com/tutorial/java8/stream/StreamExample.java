package com.tutorial.java8.stream;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        System.out.println("#### Filter and convert to map ####");
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel() > 3)
                .peek(System.out::println) // For debug
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMap);

        System.out.println("#### MAP ####");
        List<String> studentNames = StudentDataBase.getAllStudents().stream().map(Student::getName).toList();
        System.out.println(studentNames);

        System.out.println("#### FLATMAP, DISTINCT and SORTED####");
        StudentDataBase.getAllStudents().stream().flatMap(student -> student.getActivities().stream()).distinct().sorted().forEach(System.out::println);

        System.out.println("#### Sorting by name####");
        StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        System.out.println("#### Sorting by GPA in descending####");
        StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getGpa).reversed()).forEach(System.out::println);

        System.out.println("#### Reduce ####");
        System.out.println("Sum: " + Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
        System.out.println("Sum in empty list:" + new ArrayList<Integer>().stream().reduce(0, Integer::sum));
        System.out.println("Max Value:" + Stream.of(1, 2, 3, 4).reduce(0, Integer::max));
        System.out.println(StudentDataBase.getAllStudents().stream().reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2));

        System.out.println("#### Limit (Short Circuit) ####");
        System.out.println("Sum: " + Stream.of(1, 2, 3, 4).limit(2).reduce(0, Integer::sum));

        System.out.println("#### Skip ####");
        System.out.println("Sum: " + Stream.of(1, 2, 3, 4).skip(2).reduce(0, Integer::sum));

        System.out.println("#### allMatch, anyMatch and noneMatch  (Short Circuit)####");
        System.out.println("All Match: " + StudentDataBase.getAllStudents().stream().allMatch(student -> student.getGender().equals("male")));
        System.out.println("Any Match: " + StudentDataBase.getAllStudents().stream().anyMatch(student -> student.getGender().equals("male")));
        System.out.println("None Match: " + StudentDataBase.getAllStudents().stream().noneMatch(student -> student.getGender().equals("trans")));

        System.out.println("#### findAny  (Short Circuit) ####");
        System.out.println(StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa() > 3.0).findAny());
        System.out.println(StudentDataBase.getAllStudents().parallelStream().filter(student -> student.getGpa() > 3.0).findAny());

        System.out.println("#### findFirst (Short Circuit) ####");
        System.out.println(StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa() > 3.0).findFirst());
        System.out.println(StudentDataBase.getAllStudents().parallelStream().filter(student -> student.getGpa() > 3.0).findFirst());

    }
}
