package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionCheckTest {

    @Test
    public void test1(){
        Assertions.assertTrue(ExpressionCheck.checkExpression("{{}}"));
    }

    @Test
    public void test2(){
        Assertions.assertTrue(ExpressionCheck.checkExpression("({[]})"));
    }

    @Test
    public void test3(){
        Assertions.assertFalse(ExpressionCheck.checkExpression("{{]}"));
    }

    @Test
    public void test4(){
        Assertions.assertFalse(ExpressionCheck.checkExpression("{{])"));
    }

    @Test
    public void test5(){
        Assertions.assertFalse(ExpressionCheck.checkExpression("(]"));
    }

    @Test
    public void test6(){
        Assertions.assertTrue(ExpressionCheck.checkExpression("()[]{}"));
    }
}
