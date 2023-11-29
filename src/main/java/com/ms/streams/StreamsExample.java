package com.ms.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsExample {

    static List<Integer> numbers  = Arrays.asList(2,4,7,3,6,8);
    static List<String> strings = Arrays.asList("aat","bat","art","sat","cat");

    static String str = "madam";
    public static void main(String[] args) {

        //find the sum of even numbers using streams
        System.out.println(numbers.stream().filter(num -> num %2==0).reduce(0, Integer::sum));

        //filter strings that start with letter "a" and convert them into upper case
        System.out.println(strings.stream().filter(str -> str.startsWith("a")).map(String::toUpperCase).toList());

        //sort the strings in alphabetical order
        System.out.println(strings.stream().sorted().toList());

        //find the maximum value from integer
        System.out.println(numbers.stream().mapToInt(v -> v).max());

        //concat all the strings into single comma separated string
        System.out.println(strings.stream().collect(Collectors.joining(",")));

        //find the frequency of each character
        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println("collect = " + collect);
        
    }
}
