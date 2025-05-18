package com.xyz;

import com.xyz.data.Student;
import com.xyz.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerDemo {

    Predicate<Student> gradeLevelPredicate = student -> student.getGradeLevel()>3.8;
    Predicate<Student> gpaPredicate = student -> student.getGpa()>3;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name+" : "+activities);

    Consumer<Student> studentConsumer = student -> {
      if(gradeLevelPredicate.and(gpaPredicate).test(student)){
          studentBiConsumer.accept(student.getName(),student.getActivities());
      }
    };

    public void printStudentNameAndActivities(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }
    public static void main(String[] args) {

        new PredicateAndConsumerDemo().printStudentNameAndActivities(StudentDataBase.getAllStudents());
    }
}
