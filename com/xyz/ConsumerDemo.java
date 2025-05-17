package com.xyz;

import com.xyz.data.Student;
import com.xyz.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

/*
Consumer Interface - introduced in Java 8. Part of java.util.function package
(Reside under rt.jar).
 */
public class ConsumerDemo {
    static Consumer<Student> studentConsumer = student -> System.out.println(student);
    static Consumer<Student> nameConsumer = student -> System.out.print(student.getName());
    static Consumer<Student> activitiesConsumer = student -> System.out.println(student.getActivities());

    static List<Student> studentList = StudentDataBase.getAllStudents();

    public static void printStudent(){
        studentList.forEach(studentConsumer);
    }

    public static void printNameAndActivities(){
        studentList.forEach(nameConsumer.andThen(activitiesConsumer));//Consumer-Chaining
    }

    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.accept("sample-text");
        System.out.println("------------------\n------------------");
        printStudent();
        System.out.println("------------------\n------------------");
        printNameAndActivities();
    }
}