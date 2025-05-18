package com.xyz;

import com.xyz.data.Student;
import com.xyz.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentDemo {

    static List<Student> studentList = StudentDataBase.getAllStudents();
    static Predicate<Student> gradeLevelPredicate = student -> student.getGradeLevel()>3;
    static Predicate<Student> gpaPredicate = student -> student.getGpa()>3.8;

    public static void studentBasedOnGradeLevel(){
        studentList.forEach(student -> {
           if(gradeLevelPredicate.test(student)){
               System.out.println(student);
           }
        });
    }
    public static void studentBasedOnGpa(){
        studentList.forEach(student -> {
            if(gpaPredicate.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void studentBasedOnGradeAndGpa(){
        studentList.forEach(student -> {
            //if(gradeLevelPredicate.or(gpaPredicate).test(student)){
            //if(gradeLevelPredicate.or(gpaPredicate).negate().test(student)){
            if(gradeLevelPredicate.and(gpaPredicate).test(student)){
               System.out.println(student);
           }
        });
    }
    public static void main(String[] args) {

        studentBasedOnGradeLevel();
        System.out.println("------------------\n------------------");
        System.out.println("------------------\n------------------");
        studentBasedOnGpa();
        System.out.println("------------------\n------------------");
        System.out.println("------------------\n------------------");
        studentBasedOnGradeAndGpa();
    }
}
