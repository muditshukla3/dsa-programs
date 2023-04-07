package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {

    public static void main(String[] args) {
        String result = Stream.of("A", "B", "C","D").collect(Collectors.joining());
        System.out.println(result);

        result = Stream.of("A", "B", "C","D").collect(Collectors.joining(","));
        System.out.println(result);

        result= Stream.of("A", "B", "C","D").collect(Collectors.joining(",","{","}"));
        System.out.println(result);

        //instructors names seperated by , and prefix { and suffix }
        String instructorNames = Instructors.getAll().stream()
                                        .map(Instructor::getName)
                                            .collect(Collectors.joining(",", "{", "}"));
        //soutv- shortcut to print with variable name
        System.out.println("instructorNames = " + instructorNames);

    }
}
