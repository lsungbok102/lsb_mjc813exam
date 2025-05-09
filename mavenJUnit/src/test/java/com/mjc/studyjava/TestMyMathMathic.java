package com.mjc.studyjava;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMyMathMathic {
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
        assertThat(mmm.notSame(71, 51)).isEqualTo(true);
        assertThat(mmm.notSame(26, 26)).isEqualTo(false);
        assertThat(mmm.big(7842, 7841)).isEqualTo(true);
        assertThat(mmm.big(5662, 5992)).isEqualTo(false);
        assertThat(mmm.small(1234, 4567)).isEqualTo(true);
        assertThat(mmm.small(741, 541)).isEqualTo(false);
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
    }
}
