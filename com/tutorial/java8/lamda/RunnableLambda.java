package com.tutorial.java8.lamda;

public class RunnableLambda {
    public static void main(String[] args) {
        Runnable rLambda = () -> {
            System.out.println("Inside runnable!");
        };
        new Thread(rLambda).start();

        new Thread(() -> System.out.println("Shorter form!")).start();
    }
}
