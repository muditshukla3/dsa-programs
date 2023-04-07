package com.ms.streams;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapToExample {

    public static void main(String[] args) {
        IntStream.rangeClosed(0,5)
                .mapToObj(i -> {
                    return new RandomIds(i, ThreadLocalRandom.current().nextInt(100));
                }).collect(Collectors.toList()).forEach(System.out::println);
    }
}

class RandomIds{
    int id;
    int randomNumber;

    public RandomIds(int id, int randomNumber) {
        this.id = id;
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return "RandomIds{" +
                "id=" + id +
                ", randomNumber=" + randomNumber +
                '}';
    }
}
