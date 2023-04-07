package com.ms.com.ms.improvements;

public class SwitchExample {

    public static void main(String[] args) {
        String month = "JANUARY";
        String quarter = switch (month){
            case "JANUARY", "FEBURARY", "MARCH" -> "First Quarter";
            case "APRIL", "MAY", "JUNE" -> "Second Quarter";
            case "JULY", "AUGUST", "SEPTEMBER" -> "Third Quarter";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "Fourth Quarter";
            default -> "Unknown Quarter";
        };
        System.out.println("quarter = " + quarter);
    }
}
