package com.xyz;

import com.xyz.data.Student;
import com.xyz.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void getStudentNameAndActivities(){
        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name +" - "+activities);
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(student -> {
           studentBiConsumer.accept(student.getName(), student.getActivities());
        });
    }
    public static void main(String[] args) {
        BiConsumer<String, String> firstBiConsumer = (a, b) -> System.out.println("a is: "+ a + " and b is: "+ b);

        firstBiConsumer.accept("Hello", "World");

        BiConsumer<Integer, Integer> multiplyBiConsumer= (a,b) -> {
            System.out.println("Multiplication of "+a+" and "+b+" is = "+a*b);
        };

        BiConsumer<Integer,Integer> divideBiConsumer = (a,b) -> {
            System.out.println("Division of "+ a+" and "+b+" is = "+ a/b);
        };

        multiplyBiConsumer.andThen(divideBiConsumer).accept(48,4);

        System.out.println("------------------\n------------------");
        System.out.println("------------------\n------------------");

        getStudentNameAndActivities();
    }
}
