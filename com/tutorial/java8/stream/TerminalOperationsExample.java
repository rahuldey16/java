package com.tutorial.java8.stream;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TerminalOperationsExample {
    public static void main(String[] args) {

        System.out.println("#### Joining ####");
        System.out.println(StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.joining("-", "(", ")")));

        System.out.println("#### Counting ####");
        System.out.println(StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa() > 3).count());

        System.out.println("#### Mapping ####");
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.mapping(Student::getName, Collectors.toSet())));

        System.out.println("#### Min and minBy####");
        System.out.println(StudentDataBase.getAllStudents().stream().min(Comparator.comparing(Student::getGpa)));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.minBy(Comparator.comparing(Student::getGpa))));

        System.out.println("#### Max and maxBy####");
        System.out.println(StudentDataBase.getAllStudents().stream().max(Comparator.comparing(Student::getGpa)));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getGpa))));

        System.out.println("#### summingInt####");
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.summingInt(Student::getGradeLevel)));
        System.out.println((Integer) StudentDataBase.getAllStudents().stream().mapToInt(Student::getGradeLevel).sum());

        System.out.println("#### groupingBy ####");
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender)));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(student -> student.getGpa() > 3.8 ? "Outstanding" : "Average")));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender, Collectors.summingInt(Student::getGradeLevel))));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGradeLevel)), Optional::get))));
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getGender, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Student::getGradeLevel)))));

        System.out.println("#### partitioningBy ####");
        System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.partitioningBy(student -> student.getGpa() > 3.8)));


    }
}
