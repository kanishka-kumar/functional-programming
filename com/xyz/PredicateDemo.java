package com.xyz;

import java.util.function.Predicate;

public class PredicateDemo {

    static Predicate<Integer> p1 = i -> i%2==0;
    static Predicate<Integer> p2 = i -> i%5==0;

    public static void predicateAnd(){
        System.out.println(p1.and(p2).test(10));
        System.out.println(p1.and(p2).test(7));
    }

    public static void predicateOr(){
        System.out.println(p1.or(p2).test(10));
        System.out.println(p1.or(p2).test(5));
    }

    public static void predicateNot(){
        System.out.println(p1.or(p2).negate().test(10));
    }
    public static void main(String[] args) {
        System.out.println(p1.test(5));
        System.out.println("------------------\n------------------");
        predicateAnd();
        System.out.println("------------------\n------------------");
        predicateOr();
        System.out.println("------------------\n------------------");
        predicateNot();
        System.out.println("------------------\n------------------");
    }
}
