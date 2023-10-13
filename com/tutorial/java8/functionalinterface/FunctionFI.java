package com.tutorial.java8.functionalinterface;

import com.tutorial.data.Student;
import com.tutorial.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionFI {
    static Function<String, String> upperCase = String::toUpperCase;
    static Function<String, String> compose = s -> s.concat("_Hello");

    static Predicate<Student> grade = s -> s.getGradeLevel()>3;

    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunc = (studentList, gradePredicate) ->{
        Map<String,Double> studentGrade = new HashMap<>();
        studentList.forEach(student ->{
           if( gradePredicate.test(student)){
               studentGrade.put(student.getName(), student.getGpa());
           }
        });
        return studentGrade;
    };

    public static void main(String[] args) {
        System.out.println(upperCase.apply("rahul"));
        System.out.println(upperCase.compose(compose).apply("rahul"));
        System.out.println(biFunc.apply(StudentDataBase.getAllStudents(),grade));
    }
}
