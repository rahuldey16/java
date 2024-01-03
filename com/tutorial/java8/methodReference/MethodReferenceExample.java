package com.tutorial.java8.methodReference;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample {

    static int value = 4;

    public static void main(String[] args) {
        Function<String, String> stringToUpperCase = String::toUpperCase;
        Consumer<Student> printAllStudent = System.out::println;

        System.out.println(stringToUpperCase.apply("rahul"));
        StudentDataBase.getAllStudents().forEach(printAllStudent);

    }
}
