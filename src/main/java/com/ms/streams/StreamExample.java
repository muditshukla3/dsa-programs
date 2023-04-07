package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
       // creating a map of names and courses of instructors who teaches online
       // and have more than 10 yOe
        Predicate<Instructor> teachesOnlinePredicate = (i) -> i.isOnlineCourses();
        Predicate<Instructor> yearOfExpPredicate = (i) -> i.getYearsOfExperience() > 10;
        List<Instructor> instructorList = Instructors.getAll();
        Map<String, List<String>> map = instructorList.stream()
                .filter(teachesOnlinePredicate.and(yearOfExpPredicate))
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));
        System.out.println(map);

        // get a set of all the courses which instructor offers
        Set<String> instructorCourse = Instructors.getAll().stream()
                .map(Instructor::getCourses).flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(instructorCourse);

        //count
        long count = Instructors.getAll().stream()
                .map(Instructor::getCourses).flatMap(List::stream).distinct().count();
        System.out.println(count);
        List<String> instructorCourses = Instructors.getAll().stream()
                .map(Instructor::getCourses).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
        System.out.println(instructorCourses);
    }
}
