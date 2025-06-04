package org.example;

import java.util.regex.Pattern;

public class MjcValidCheck {

    public boolean isValidPhoneNumber(String text) {
        if (text == null) return false;
        return Pattern.matches("^010-\\d{4}-\\d{4}$", text);
    }

    public boolean isValidZipNumber(String text) {
        if (text == null) return false;
        return Pattern.matches("^[1-9]\\d{4}$", text);
    }

    public boolean isValidEmail(String text) {
        if (text == null) return false;
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", text);
    }
}
