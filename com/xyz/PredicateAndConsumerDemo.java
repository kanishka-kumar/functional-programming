package com.xyz;

import com.xyz.data.Student;
import com.xyz.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerDemo {

    Predicate<Student> gradeLevelPredicate = student -> student.getGradeLevel()>3.8;
    Predicate<Student> gpaPredicate = student -> student.getGpa()>3;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name+" : "+activities);

    BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel>3.8 && gpa>3;

    Consumer<Student> studentConsumer = student -> {
      if(gradeLevelPredicate.and(gpaPredicate).test(student)){
          studentBiConsumer.accept(student.getName(),student.getActivities());
      }
    };

    Consumer<Student> studentConsumerUsingBiPredicate = student -> {
        if(biPredicate.test(student.getGradeLevel(),student.getGpa())){
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    };

    public void printStudentNameAndActivitiesUsingConsumer(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }

    public void printStudentNameAndActivitiesUsingBiPredicate(List<Student> students){
        students.forEach(studentConsumerUsingBiPredicate);
    }
    public static void main(String[] args) {

        new PredicateAndConsumerDemo().printStudentNameAndActivitiesUsingConsumer(StudentDataBase.getAllStudents());
        System.out.println("------------------\n------------------");
        System.out.println("------------------\n------------------");
        new PredicateAndConsumerDemo().printStudentNameAndActivitiesUsingBiPredicate(StudentDataBase.getAllStudents());
    }
}
