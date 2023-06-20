package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMappingExample {

    public static void main(String[] args) {
        //map
        List<String> namesList = Instructors.getAll().stream()
                .map(Instructor::getName).collect(Collectors.toList());
        System.out.println("namesList = " + namesList);

        //mapping
        namesList = Instructors.getAll().stream()
                .collect(Collectors.mapping(Instructor::getName,Collectors.toList()));
        System.out.println("namesList = " + namesList);

        //Instructors by their years of experience
        Map<Integer, List<String>> mapYearOfExpNames= Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName, Collectors.toList())));
        System.out.println("mapYearOfExpNames = " + mapYearOfExpNames);

        // Instructor with nth highest experience
        System.out.println(getInstructorWithNthHighestExperience(3, Instructors.getAll()));
    }

    private static Map.Entry<Integer, List<String>> getInstructorWithNthHighestExperience(int exp,
                                                                                          List<Instructor> instructors) {
       return instructors
                .stream()
                .collect(
                        Collectors.groupingBy(Instructor::getYearsOfExperience,
                Collectors.mapping(Instructor::getName, Collectors.toList())))
               .entrySet().stream().collect(Collectors.toList()).get(exp-1);
    }
}
