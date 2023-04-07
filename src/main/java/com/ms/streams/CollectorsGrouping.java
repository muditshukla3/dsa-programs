package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsGrouping {

    public static void main(String[] args) {
        //group list of names by their length
        Map<Integer, List<String>> instructorsNamesByLength = Instructors.getAll().stream()
                .map(Instructor::getName)
                .collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(String::length));
        System.out.println("instructorsNamesByLength = " + instructorsNamesByLength);

        //grouping by instructors by their gender
        Map<String, List<Instructor>> instructorsNamesByGender = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getGender));
        System.out.println("instructorsNamesByGender = " + instructorsNamesByGender);

        //grouping by experience > 10 as senior adn others as junior
        Map<String, List<Instructor>> instructorByExp = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(instructor -> instructor.getYearsOfExperience()>10?"Senior":"Junior"));
        System.out.println("instructorByExp = " + instructorByExp);

        //grouping by length of string and also checking that the names contain e
        //and only return those name which has e in it
        Map<Integer, List<String>> instructorsNamesByLengthAndEChar = Instructors.getAll().stream()
                .map(Instructor::getName)
                .collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(String::length,
                        Collectors.filtering(s -> s.contains("e"),
                                Collectors.toList())));
        System.out.println("instructorsNamesByLengthAndEChar = " + instructorsNamesByLengthAndEChar);

        //instructor grouping them by Senior(>10) and Junior(<10) and filter them
        //on online courses
        Map<String, List<Instructor>> instructorByExpAndOnline = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(instructor -> instructor.getYearsOfExperience()>10?"SENIOR":"JUNIOR",
                        Collectors.filtering(s -> s.isOnlineCourses(), Collectors.toList())));
        System.out.println("instructorByExpAndOnline = " + instructorByExpAndOnline);

        //grouping instructors in two sets of online course vs not online
        //and get the max years of experience of the instructor
        Map<Boolean, Optional<Instructor>> maxInstructors1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses, 
                        Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience))));
        System.out.println("maxInstructors1 = " + maxInstructors1);

        //collectingAndThen
        Map<Boolean, Instructor> maxInstructors2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience)),
                                Optional::get)));
        System.out.println("maxInstructors2 = " + maxInstructors2);

        //average years of experience of instructors who teaches online or not
        Map<Boolean, Double> avgExpOfInstructors = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses, Collectors.averagingInt(Instructor::getYearsOfExperience)));
        System.out.println("avgExpOfInstructors = " + avgExpOfInstructors);
    }
}
