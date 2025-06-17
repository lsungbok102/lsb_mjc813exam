package com.mjc813.studyjava;

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

    public boolean same(String a, String b) {
        return a.equals(b);
    }

    public boolean notSame(int a, int b) {
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
        return Integer.parseInt(a);
    }

    public int avg(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int sumOfNumber(int[] array, int number) {
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
        if (a > b) {
            return 0;
        }
        return a + sumOfFav(a + 1, b);
    }

    public BigDecimal getBigDecimal(Integer n, Integer s) {
        return new BigDecimal(n + "." + s);
    }

    public Integer[] getIntegerArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public int[] makeRandomIntArray(int n) {
        Random rand = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt();
        }
        return result;
    }

    public String makeEncryptString(String text, int n) {
        Random rand = new Random();
        int len = text.length();
        int totalLength = n * len;
        char[] result = new char[totalLength];

        for (int i = 0; i < totalLength; i++) {
            result[i] = randomChar(rand);
        }

        for (int i = 0; i < len; i++) {
            result[i * n] = text.charAt(i);
        }

        return new String(result);
    }

    public String makeDecryptString(String code, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % n == 0) {
                sb.append(code.charAt(i));
            }
        }
        return sb.toString();
    }

    private static char randomChar(Random rand) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return chars.charAt(rand.nextInt(chars.length()));
    }
}
