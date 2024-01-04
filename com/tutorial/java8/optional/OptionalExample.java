package com.tutorial.java8.optional;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String str = "Rahul";
        Optional<String> strOptional = Optional.of(str);
        System.out.println(strOptional);
        System.out.println(strOptional.get());

        System.out.println(Optional.empty());
        Optional<String> strNullable = Optional.ofNullable(null);
        System.out.println(strNullable);
        System.out.println(strNullable.isPresent());

        System.out.println("#### orElse. orElseGet, orElseThrow ####");
        System.out.println(strNullable.map(String::toUpperCase).orElse("Default"));
        System.out.println(strNullable.map(String::toUpperCase).orElseGet(() -> "Default"));
        try {
            System.out.println(strNullable.map(String::toUpperCase).orElseThrow(NoSuchElementException::new));
        } catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException ");
        }

        System.out.println("#### isPresent, ifPresent ####");
        Optional<String> present = Optional.of("Rahul");
        System.out.println(present.isPresent());
        present.ifPresent(System.out::println);

        System.out.println("#### filter and map ####");
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier().get());
        student.filter(student1 -> student1.getGpa() > 2.0).map(Student::getName).ifPresent(System.out::println);
    }
}
