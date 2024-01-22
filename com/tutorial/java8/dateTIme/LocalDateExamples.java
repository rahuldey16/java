package com.tutorial.java8.dateTIme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateExamples {
    public static void main(String[] args) {
        System.out.println("Print today's date: "+ LocalDate.now());
        System.out.println("Print current time: "+ LocalTime.now());
        System.out.println("Print current date and time: "+ LocalDateTime.now());

        System.out.println(LocalDate.of(2024,1, 9));
        System.out.println(LocalDate.ofYearDay(2024,45));
        System.out.println(LocalDate.ofYearDay(2024,45).getMonth());
        System.out.println(LocalDate.ofYearDay(2024,45).getDayOfWeek());

        System.out.println(LocalDate.now().plusDays(10));
        System.out.println(LocalDate.now().plusMonths(5));
        System.out.println(LocalDate.now().minusDays(5));

        System.out.println("#### Period - Comparing days####");
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 5, 31);

        System.out.println(date1.until(date2).getDays());
        System.out.println(date1.until(date2).getMonths());
        System.out.println(date1.until(date2).getYears());

        System.out.println("#### Duration - Comparing times####");
        LocalTime time1 = LocalTime.of(10, 20);
        LocalTime time2 = LocalTime.of(5, 30);

        System.out.println(time2.until(time1, ChronoUnit.HOURS));
        System.out.println(time2.until(time1, ChronoUnit.MINUTES));
    }
}
