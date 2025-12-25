package com.airtribe.learntrack.util;

public class InputValidator {
    public static boolean isValidInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

