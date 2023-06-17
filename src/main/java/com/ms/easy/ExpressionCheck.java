package com.ms.easy;

import java.util.*;

/**
 * Given a string s containing just the characters
 * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class ExpressionCheck {

    public static boolean checkExpression(String str){

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> parenthesis = new HashMap<>();
        parenthesis.put('(', ')');
        parenthesis.put('{','}');
        parenthesis.put('[',']');

        for (char ch: str.toCharArray()) {

            if(stack.isEmpty() && (ch=='}' || ch==']' || ch==')')){
                return false;
            }

            if(!stack.empty() && parenthesis.get(stack.peek()) == ch){
                stack.pop();
            }else if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                return false;
            }
        }

        return stack.empty();
    }

    public static boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i<str.length(); i++) {
            if(!map.containsKey((str.charAt(i)))){
                stack.offerFirst(str.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }else {
                    if(stack.peekFirst() == map.get(str.charAt(i))){
                        stack.pollFirst();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
