package com.ms.fp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        // Map of instructors with name and year of experience
        // Function which will take List<Instructor> and return a Map<String, Integer>

        List<Instructor> instructorList = Instructors.getAll();
        Function<List<Instructor>, Map<String, Integer>> function = (list) -> {
            Map<String, Integer> map = new HashMap<>();
            list.forEach(item -> map.put(item.name, item.yearsOfExperience));
            return map;
        };

        System.out.println(function.apply(instructorList));
    }
}
