package com.dwhyt.platzi.test.challenge;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FisrtChallengeShould {

    @Test
    public void divisible_by_3() {
        assertThat(FisrtChallenge.fizzBuzz(3), is("Fizz"));
        assertThat(FisrtChallenge.fizzBuzz(6), is("Fizz"));
        assertThat(FisrtChallenge.fizzBuzz(9), is("Fizz"));
        assertThat(FisrtChallenge.fizzBuzz(33), is("Fizz"));
        assertThat(FisrtChallenge.fizzBuzz(42), is("Fizz"));
    }

    @Test
    public void divisible_by_5() {
        assertThat(FisrtChallenge.fizzBuzz(5), is("Buzz"));
        assertThat(FisrtChallenge.fizzBuzz(65), is("Buzz"));
        assertThat(FisrtChallenge.fizzBuzz(80), is("Buzz"));
    }

    @Test
    public void divisible_by_3_and_5() {
        assertThat(FisrtChallenge.fizzBuzz(15), is("FizzBuzz"));
        assertThat(FisrtChallenge.fizzBuzz(30), is("FizzBuzz"));
    }


    @Test
    public void not_divisible_by_3_and_5() {
        assertThat(FisrtChallenge.fizzBuzz(2), is("2"));
        assertThat(FisrtChallenge.fizzBuzz(8), is("8"));
    }


}