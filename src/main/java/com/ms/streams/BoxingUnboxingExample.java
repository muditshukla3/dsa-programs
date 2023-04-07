package com.ms.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxingExample {

    public static void main(String[] args) {
        IntStream numStream = IntStream.range(0,10);
        List<Integer> numbers =
                numStream.boxed().collect(Collectors.toList());

        Optional<Integer> sum = numbers.stream().reduce((a, b)-> a+b);
        System.out.println(sum.isPresent()?sum.get():0);

        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);
    }
}
