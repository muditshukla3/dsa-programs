package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionByExample {

    public static void main(String[] args) {
        // partition instructors in two groups of instructor
        // first is year of exp > 10 and other is <=10

        Predicate<Instructor> expreriencePredicate = instructor -> instructor.getYearsOfExperience() > 10;

        Map<Boolean, List<Instructor>> paritionMap = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(expreriencePredicate));
        System.out.println("paritionMap = " + paritionMap);

        //partition but return is set instead of list
        Map<Boolean, Set<Instructor>> partitionSet = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(expreriencePredicate, Collectors.toSet()));
        System.out.println("partitionSet = " + partitionSet);
    }
}
