package com.mjc.studyjava;

import java.math.BigDecimal;
import java.util.Random;

public class MyMathMathic {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public long mul(int a, int b) {
        return (long) a * b;
    }

    public int divM(int a, int b) {
        return a / b;
    }

    public int divN(int a, int b) {
        return a % b;
    }

    public boolean same(int a, int b) {
        return a == b;
    }

    public boolean same(Object a, Object b) {
        if (a == null || b == null) {
            return a == b;
        }

        return a.equals(b);
    }

    public boolean notsame(int a, int b) {
        return a != b;
    }

    public boolean big(int a, int b) {
        return a > b;
    }

    public boolean small(int a, int b) {
        return a < b;
    }

    public int shiftLeft(int a, byte b) {
        return a << b;
    }

    public int shiftRight(int a, byte b) {
        return a >> b;
    }

    public int shiftRight0(int a, byte b) {
        return a >>> b;
    }

    public long square(int a, byte b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public int absolute(int a) {
        return (a > 0) ? a : -a;
    }

    public String toHex(int a) {
        return Integer.toHexString(a);
    }

    public String toBin(int a) {
        return Integer.toBinaryString(a);
    }

    public String toOct(int a) {
        return Integer.toOctalString(a);
    }

    public int toDec(String a) {
        if (a == null) {
            return 0;
        }
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int avg(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }


    public int sum(int[] array) {
        if (array == null) return 0;
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public int sumOfNumber(int[] array, int number) {
        if (array == null) return 0;
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % number == 0) {
                total += array[i];
            }
        }
        return total;
    }

    public int sumOfLoop(int a, int b) {
        int total = 0;
        for (int i = a; i <= b; i++) {
            total += i;
        }
        return total;
    }

    public int sumOfFav(int a, int b) {
        if (a > b) return 0;
        return a + sumOfFav(a + 1, b);
    }

    public BigDecimal getBigDecimal(Integer n, Integer s) {
        if (n == null || s == null) return BigDecimal.ZERO;
        return new BigDecimal(n + "." + s);
    }

    public Integer[] getIntegerArray(int[] array) {
        if (array == null) return null;
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public int[] makeRandomIntArray(int n) {
        if (n <= 0) return new int[0];
        Random rand = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt();
        }
        return result;
    }

    public String makeEncryptString(String text, int n) {
        if (text == null || n < 5) return "";
        Random rand = new Random();
        int len = text.length();
        int totalLength = n * len + 1;
        char[] result = new char[totalLength];

        for (int i = 0; i < totalLength; i++) {
            result[i] = randomChar(rand);
        }

        for (int i = 0; i < len; i++) {
            result[i * n + 5] = text.charAt(i);
        }

        return new String(result);
    }

    public String makeDecryptString(String encryptedText, int n) {
        if (encryptedText == null || n < 5) return "";

        int len = encryptedText.length();
        StringBuilder originalText = new StringBuilder();

        for (int i = 5; i < len; i += n) {
            originalText.append(encryptedText.charAt(i));
        }

        return originalText.toString();
    }

    private char randomChar(Random rand) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return chars.charAt(rand.nextInt(chars.length()));
    }
}
