package com.dwhyt.platzi.test.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

    private static List<String> roman_num = Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I");
    private static List<Integer> roman_value = Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1);

    public static String arabicToRoman(int n){

        String result = "";
        int i = 0;
        while (n>0) {
            int j=0;
            while(j < n/roman_value.get(i)){
                result += roman_num.get(i);
                n -= roman_value.get(i);
            }
        i++;
        }

        return result;
    }
}
