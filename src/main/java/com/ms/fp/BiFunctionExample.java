package com.ms.fp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    public static void main(String[] args) {
        // BiFunction 2 input, List<Instructors> and second is predicate which will filter if instructor has online courses
        // and return map of string is name and integer is yOe
        List<Instructor> instructorList = Instructors.getAll();
        Predicate<Instructor> teachesOnlinePredicate = (i) -> i.onlineCourses;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> biFunction = (list, predicate) -> {
            Map<String, Integer> map = new HashMap<>();
            list.forEach(item -> {
                if(predicate.test(item)){
                    map.put(item.name, item.yearsOfExperience);
                }
            });
            return map;
        };
        System.out.println(biFunction.apply(instructorList,teachesOnlinePredicate));
    }


}
