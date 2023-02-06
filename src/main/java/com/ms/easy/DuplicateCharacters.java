package com.ms.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateCharacters {

    public static <T> Set<T> findDuplicateStream(Stream<T> stream){
        Set<T> items = new HashSet<>();
        return stream.filter(n -> !items.add(n)).collect(Collectors.toSet());
    }
}
