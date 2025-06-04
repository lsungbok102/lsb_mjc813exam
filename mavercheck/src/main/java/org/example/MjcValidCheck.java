package org.example;

public class MjcValidCheck {
    public boolean isValidPhoneNumber(String text) {
        if (text != null && text.length() == 13 && text.startsWith("010-")) {
            if (text.charAt(8) != '-') {
                return false;
            } else {
                for(int i = 4; i <= 7; ++i) {
                    if (text.charAt(i) < '0' || text.charAt(i) > '9') {
                        return false;
                    }
                }

                for(int i = 9; i < text.length(); ++i) {
                    if (text.charAt(i) < '0' || text.charAt(i) > '9') {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public boolean isValidZipNumber(String text) {
        if (text != null && text.length() == 5 && text.charAt(0) != '0') {
            for(int i = 1; i < text.length(); ++i) {
                if (text.charAt(i) < '0' || text.charAt(i) > '9') {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isValidEmail(String text) {
        if (text.contains("@") && text.contains(".")) {
            int connect = text.indexOf("@");
            int com = text.indexOf(".");
            return connect != 0 && connect + 2 <= com && text.length() >= com + 3;
        } else {
            return false;
        }
    }
}
