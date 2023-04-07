package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class StreamReduceExample {
    public static void main(String[] args) {

        // print the instructor who has highest year of exp
        Optional instructor = Instructors.getAll().stream()
                .reduce((s1, s2) -> s1.getYearsOfExperience()>s2.getYearsOfExperience()?s1:s2);
        if(instructor.isPresent())
            System.out.println(instructor.get());

        // total years of experience b/w instructors
        int result = Instructors.getAll().stream().filter(Instructor::isOnlineCourses)
                .map(Instructor::getYearsOfExperience).reduce(0, Integer::sum);
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(8,3,9,4,9,1,2,7);
        Optional<Integer> min = numbers.stream().max(Integer::compareTo);
        System.out.println(min.get());

        Stream.iterate(0, i-> i+2).limit(10);
        Stream.generate(new Random()::nextInt).limit(5);
    }
}
