package com.ms.streams;

import com.ms.fp.Instructor;
import com.ms.fp.Instructors;

import java.util.stream.Collectors;

// Collectors.counting() method counts the number of elements in a stream
// Helpful in Downstream operations groupingBy(String::length, counting());
public class CountingExample {

    public static void main(String[] args) {
        // count the number of instructors who teaches online courses
        //stream.count
        long count = Instructors.getAll().stream().filter(Instructor::isOnlineCourses).count();
        System.out.println("count = " + count);

        //collectors.counting()
        count = Instructors.getAll().stream().filter(Instructor::isOnlineCourses).collect(Collectors.counting());
        System.out.println("count = " + count);
    }
}
