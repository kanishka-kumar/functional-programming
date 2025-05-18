package com.xyz.data;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> firstBiConsumer = (a, b) -> System.out.println("a is: "+ a + " and b is: "+ b);

        firstBiConsumer.accept("Hello", "World");
    }
}
