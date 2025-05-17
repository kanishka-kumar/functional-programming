package com.xyz;

import java.util.function.Consumer;

/*
Consumer Interface - introduced in Java 8. Part of java.util.function package
(Reside under rt.jar).
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.accept("sample-text");
    }
}