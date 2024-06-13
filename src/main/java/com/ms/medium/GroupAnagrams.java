package com.ms.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

    public static Set<Set<String>> groupAnagrams(List<String> words){
        Set<Set<String>> anagrams = new HashSet<>();

        if(words.isEmpty()){
            return anagrams;
        }

        // sort each word
        List<String> list = words.stream()
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining())).toList();

        // construct a map where key is word and value
        // is list of indices where it's present
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }

        for(var entry: map.entrySet()){
            Set<String> collection = entry.getValue()
                                        .stream()
                                        .map(words::get)
                                        .collect(Collectors.toSet());
            if(!collection.isEmpty()){
                anagrams.add(collection);
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("CARS", "NOSE", "SIGNED",
                "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN");

        Set<Set<String>> anagrams = groupAnagrams(words);
        System.out.println(anagrams);
    }
}
