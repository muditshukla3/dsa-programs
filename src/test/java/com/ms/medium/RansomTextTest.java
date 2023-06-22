package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RansomTextTest {


    @ParameterizedTest
    @CsvSource({"a,b","aa,ab"})
    public void cannotConstruct(String ransomText, String magazineText){
        Assertions.assertFalse(RansomText.canRansomTextConstruct(ransomText,magazineText));
    }
    @ParameterizedTest
    @CsvSource({"ba,aba","aaa,aabab"})
    public void canConstruct(String ransomText, String magazineText){
        Assertions.assertTrue(RansomText.canRansomTextConstruct(ransomText,magazineText));
    }

}
