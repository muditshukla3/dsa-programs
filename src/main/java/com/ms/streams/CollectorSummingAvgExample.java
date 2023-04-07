package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.stream.Collectors;

public class CollectorSummingAvgExample {
    public static void main(String[] args) {

        //sum of years of experience of all instructor
        int sum = Instructors.getAll().stream()
                .collect(Collectors.summingInt(Instructor::getYearsOfExperience));
        System.out.println("sum = " + sum);
        
        double average = Instructors.getAll().stream()
                .collect(Collectors.averagingInt(Instructor::getYearsOfExperience));
        System.out.println("average = " + average);
    }
}
