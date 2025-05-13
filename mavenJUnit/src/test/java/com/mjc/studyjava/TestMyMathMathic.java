package com.mjc.studyjava;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMyMathMathic {
    private int nn;
    @Test
    public void testMyTest() {
        MyMathMathic mmm = new MyMathMathic();
        assertThat(mmm.add(1, 11)).isEqualTo(12);
        assertThat(mmm.add(0, -30)).isEqualTo(-30);
        assertThat(mmm.sub(100, 30)).isEqualTo(70);
        assertThat(mmm.sub(0, -30)).isEqualTo(30);
        assertThat(mmm.mul(5, -7)).isEqualTo(-35);
        assertThat(mmm.mul(100, 75)).isEqualTo(7500);
        assertThat(mmm.divM(10, 5)).isEqualTo(2);
        assertThat(mmm.divM(990, 10)).isEqualTo(99);
        assertThat(mmm.divN(57, 5)).isEqualTo(2);
        assertThat(mmm.divN(4578, 2)).isEqualTo(0);

        assertThat(mmm.same(1, 1)).isEqualTo(true);
        assertThat(mmm.same(26, 25)).isEqualTo(false);
        assertThat(mmm.same("26", "26")).isEqualTo(true);
        assertThat(mmm.same("126", "")).isEqualTo(false);
        assertThat(mmm.same(null, "ab")).isEqualTo(false);
        assertThat(mmm.same("null", null)).isEqualTo(false);
        assertThat(mmm.notSame(71, 51)).isEqualTo(true);
        assertThat(mmm.notSame(26, 26)).isEqualTo(false);
        assertThat(mmm.big(7842, 7841)).isEqualTo(true);
        assertThat(mmm.big(5662, 5992)).isEqualTo(false);
        assertThat(mmm.big(1111, 1111)).isEqualTo(false);
        assertThat(mmm.small(1234, 4567)).isEqualTo(true);
        assertThat(mmm.small(741, 541)).isEqualTo(false);
        assertThat(mmm.small(4444, 4444)).isEqualTo(false);
        assertThat(mmm.shiftLeft(1234, (byte)5)).isEqualTo(39488);
        assertThat(mmm.shiftLeft(748, (byte)7)).isEqualTo(95744);
        assertThat(mmm.shiftRight(9854122, (byte)8)).isEqualTo(38492);
        assertThat(mmm.shiftRight(41502, (byte)5)).isEqualTo(1296);
        assertThat(mmm.shiftRight0(-5873084, (byte)8)).isEqualTo(16754274);
        assertThat(mmm.shiftRight0(-29211, (byte)3)).isEqualTo(536867260);
        assertThat(mmm.square(2, (byte)10)).isEqualTo(1024);
        assertThat(mmm.square(7, (byte)14)).isEqualTo(678223072849L);
        assertThat(mmm.absolute(7)).isEqualTo(7);
        assertThat(mmm.absolute(-77)).isEqualTo(77);
        assertThat(mmm.toHex(58745)).isEqualTo("e579");
        assertThat(mmm.toHex(698)).isEqualTo("2ba");
        assertThat(mmm.toBin(74156)).isEqualTo("10010000110101100");
        assertThat(mmm.toBin(9871)).isEqualTo("10011010001111");
        assertThat(mmm.toOct(7568)).isEqualTo("16620");
        assertThat(mmm.toOct(961)).isEqualTo("1701");
        assertThat(mmm.toDec("234123")).isEqualTo(234123);
        assertThat(mmm.toDec("77")).isEqualTo(77);
        assertThat(mmm.toDec(null)).isEqualTo(0);
    }
    @Test
    public void testMyTestArray() {
        MyMathMathic mmm = new MyMathMathic();
        assertThat(mmm.avg(new int[] {1, 2, 3, 4, 5})).isEqualTo(3);
        assertThat(mmm.avg(new int[] {2, 4, 6, 8, 10})).isEqualTo(6);
        assertThat(mmm.avg(null)).isEqualTo(0);
        assertThat(mmm.sum(new int[] {10, 1, 2, 4, 6, 7})).isEqualTo(30);
        assertThat(mmm.sum(new int[] {90, 7, 3, 61, 39, 100})).isEqualTo(300);
        assertThat(mmm.sum(null)).isEqualTo(0);
        assertThat(mmm.sumOfNumber(new int[] {1, 3, 8, 12, 15, 16, 20, 21}, 4)).isEqualTo(56);
        assertThat(mmm.sumOfNumber(new int[] {1, 3, 8, 12, 15, 16, 20, 21}, 3)).isEqualTo(51);
        assertThat(mmm.sumOfNumber(null, 3)).isEqualTo(0);
        assertThat(mmm.sumOfLoop(1, 10)).isEqualTo(55);
        assertThat(mmm.sumOfLoop(90, 100)).isEqualTo(1045);
        assertThat(mmm.sumOfFav(1, 10)).isEqualTo(55);
        assertThat(mmm.sumOfFav(90, 100)).isEqualTo(1045);

        assertThat(mmm.getBigDecimal(3643, 5630932)).isEqualTo(new BigDecimal("3643.5630932"));
        assertThat(mmm.getBigDecimal(-741874895, 1004780065)).isEqualTo(new BigDecimal("-741874895.1004780065"));
        assertThat(mmm.getBigDecimal(0, 0)).isEqualTo(new BigDecimal("0.0"));
        assertThat(mmm.getIntegerArray(new int[] {7, 89, 201, 31})).isEqualTo(new Integer[] {7, 89, 201, 31});
        assertThat(mmm.getIntegerArray(new int[] {-201, 89, 5, 2, 17, -32029})).isEqualTo(new Integer[] {-201, 89, 5, 2, 17, -32029});
        assertThat(mmm.getIntegerArray(null)).isEqualTo(null);
        int[] randomArray = mmm.makeRandomIntArray(5);
        assertThat(randomArray).isNotNull();
        assertThat(randomArray.length).isEqualTo(5);
        String sEnc1 = mmm.makeEncryptString("mjc813", 5);
        String sEnc2 = mmm.makeEncryptString("LeeSunSin", 5);
        assertThat(sEnc1.length()).isEqualTo(31);
        assertThat(sEnc2.length()).isEqualTo(46);
        assertThat(mmm.makeEncryptString(null, 5)).isEqualTo("");
        String sOrg1 = mmm.makeDecryptString(sEnc1, 5);
        String sOrg2 = mmm.makeDecryptString(sEnc2, 5);
        assertThat(sOrg1).isEqualTo("mjc813");
        assertThat(sOrg1.length()).isEqualTo(6);
        assertThat(sOrg2).isEqualTo("LeeSunSin");
        assertThat(sOrg2.length()).isEqualTo(9);
        assertThat(mmm.makeDecryptString(null, 5)).isEqualTo("");
    }
}
