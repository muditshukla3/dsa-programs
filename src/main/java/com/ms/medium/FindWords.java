package com.ms.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  examples
 *  findWord(["P>E","E>R","R>U"]) // PERU
 * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
 * // solve using linked list
 */
public class FindWords {

    static List<String> words = new LinkedList<>();
    public static void main(String[] args) {
        //System.out.println(findWords(new String[]{"P>E","E>R","R>U"}));
        System.out.println(findWords(new String[]{"I>N","A>I","P>A","S>P"}));
    }

    // P E
    // E R
    // R U

    // SPAIN
    // I N
    // P A
    // A I
    // S P
    public static String findWords(String[] input){
        List<String> inputList = Arrays.asList(input);
        inputList.stream().forEach(str -> addToList(str.split(">")));
        StringBuilder finalString = new StringBuilder();
        words.stream().forEach(item-> finalString.append(item));
        return finalString.toString();
    }

    private static void addToList(String[] inputs){
        if(words.size()==0){
            words.add(inputs[0]);
            words.add(inputs[1]);
        }else{
            if(words.contains(inputs[0]) && (words.indexOf(inputs[0])==words.size()-1)){
                words.add(inputs[1]);
            }else{
                words.add(words.indexOf(inputs[0]), inputs[0]);
            }
        }
    }
}
