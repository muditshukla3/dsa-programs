package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExpressionCheckTest {

    @ParameterizedTest
    @ValueSource(strings = {"{{}}", "({[]})", "()[]{}"})
    public void validExpression(String expression){
        Assertions.assertTrue(ExpressionCheck.checkExpression(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"{{]}", "{{])", "(]"})
    public void invalidExpression(String expression){
        Assertions.assertFalse(ExpressionCheck.checkExpression(expression));
    }


}
