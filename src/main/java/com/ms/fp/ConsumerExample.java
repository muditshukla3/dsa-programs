package com.ms.fp;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerExample {

    public static void main(String[] args) {

        List<Instructor> instructorList = Instructors.getAll();

        //looping through all the instructors and printing out the values
//        Consumer<Instructor> consumer = (i) -> System.out.println(i);
//        instructorList.forEach(consumer);

        //loop through all the instructor and only print out their name
        Consumer<Instructor> namePrintConsumer = (i) -> System.out.println(i.name);


        //loop through all the instructors and print out their names and their courses
        Consumer<Instructor> coursePrintConsumer = (i) -> System.out.println(i.courses);
        //instructorList.forEach(namePrintConsumer.andThen(coursePrintConsumer));

        //filter instructors where yOe is > 5
        Predicate<Instructor> yearOfExpPredicate = (i) -> i.yearsOfExperience>5;
        //filter instructors who does not teach online
        Predicate<Instructor> teachesOnlinePredicate = (i) -> !i.onlineCourses;
        BiPredicate<Boolean, Integer> yearOfExpTeachedOnline = (online, experience) -> online && experience> 11;

        //instructorList.stream().filter(yearOfExpPredicate.and(teachesOnlinePredicate)).forEach(namePrintConsumer);
        instructorList.forEach(instructor -> {
            if(yearOfExpTeachedOnline.test(instructor.onlineCourses , instructor.yearsOfExperience)){
                namePrintConsumer.accept(instructor);
            }
        });

        Function<Integer, Double> sqrt = n -> Math.sqrt(n);
        System.out.println (sqrt.apply(8));
    }
}
