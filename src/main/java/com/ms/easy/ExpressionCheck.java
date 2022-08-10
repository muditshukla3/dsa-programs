package com.ms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

}
