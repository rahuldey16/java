package com.tutorial.java8.functionalinterface;

import com.tutorial.data.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFI {
    public static void main(String[] args) {
        Supplier<Student> newStudent = ()->{
            return new Student("Rahul", 4, 3.9, "male", List.of("Football, Cricket, TT"));
        };
        System.out.println(newStudent.get());
    }
}
