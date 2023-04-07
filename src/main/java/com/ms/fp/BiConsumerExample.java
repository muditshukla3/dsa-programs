package com.ms.fp;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class BiConsumerExample {

    public static void main(String[] args) {

        List<Instructor> instructorList = Instructors.getAll();

        // print out name and gender
        BiConsumer<String, String> nameAndGender = (name, gender) -> System.out.println("Name: "+name+" Gender: "+gender);
        //instructorList.forEach(instructor -> nameAndGender.accept(instructor.name, instructor.gender));

        // print out name and gender of all instructors who teaches online
        Predicate<Instructor> teachesOnlinePredicate = (i) ->  i.onlineCourses;
        instructorList.stream().filter(teachesOnlinePredicate)
                .forEach(instructor -> nameAndGender.accept(instructor.name, instructor.gender));
    }
}
