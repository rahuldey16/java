package com.tutorial.java8.functionalinterface;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerFI {
    public static void main(String[] args) {
        Consumer<String> consumerStringUpperCase = s -> System.out.println(s.toUpperCase());
        consumerStringUpperCase.accept("java");

        Consumer<Student> displayStudentName = s -> System.out.print(s.getName());
        Consumer<Student> displayStudentActivities = s -> System.out.println(s.getActivities());

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(displayStudentName.andThen(displayStudentActivities));
    }
}
