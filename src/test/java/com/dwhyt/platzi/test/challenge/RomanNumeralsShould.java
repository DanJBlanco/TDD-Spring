package com.dwhyt.platzi.test.challenge;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsShould {
    /***
     * Pruebas
     *
     arabicToRoman(5) ⇒ "V"
     arabicToRoman(6) ⇒ "VI"
     arabicToRoman(7) ⇒ "VII"
     arabicToRoman(10) ⇒ "X"
     arabicToRoman(11) ⇒ "XI"
     arabicToRoman(15) ⇒ "XV"
     arabicToRoman(16) ⇒ "XVI"
     arabicToRoman(50) ⇒ "L"
     arabicToRoman(51) ⇒ "LI"
     arabicToRoman(55) ⇒ "LV"
     arabicToRoman(56) ⇒ "LVI"
     arabicToRoman(60) ⇒ "LX"
     arabicToRoman(70) ⇒ "LXX"
     arabicToRoman(80) ⇒ "LXXX"
     arabicToRoman(81) ⇒ "LXXXI"
     arabicToRoman(85) ⇒ "LXXXV"
     arabicToRoman(86) ⇒ "LXXXVI"
     arabicToRoman(126) ⇒ "CXXVI"
     arabicToRoman(2507) ⇒ "MMDVII"
     */

    @Test
    public void I_when_number_is_3_2_1() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void IV_when_number_is_4() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }
    @Test
    public void V_when_number_is_5() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void VI_when_number_is_more_than_5_and_less_than_9() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
        assertThat(RomanNumerals.arabicToRoman(8), is("VIII"));
    }

    @Test
    public void IX_when_number_is_9() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }

    @Test
    public void X_when_number_is_10() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void XI_when_number_is_more_than_10_and_less_than_50() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
        assertThat(RomanNumerals.arabicToRoman(13), is("XIII"));
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
        assertThat(RomanNumerals.arabicToRoman(46), is("XLVI"));
    }

    @Test
    public void L_when_number_is_50() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void LPLUS_when_number_is_more_than_50_and_less_than_100() {
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
    }

    @Test
    public void C_when_number_is_100() {
        assertThat(RomanNumerals.arabicToRoman(100),is("C"));
    }

    @Test
    public void CPLUS_when_number_is_more_than_100_and_less_100() {
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void D_when_number_is_500() {
        assertThat(RomanNumerals.arabicToRoman(500),is("D"));
    }

    @Test
    public void M_when_number_is_1000() {
        assertThat(RomanNumerals.arabicToRoman(1000),is("M"));
    }

    @Test
    public void MPLUS_when_number_is_more_than_1000() {
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }
}