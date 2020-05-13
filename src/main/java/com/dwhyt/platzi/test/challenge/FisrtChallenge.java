package com.dwhyt.platzi.test.challenge;

public class FisrtChallenge {

    public static String fizzBuzz(int n){
        if(  n % 3 == 0){
            if(n%5 == 0 ){
                return "FizzBuzz";
            }
            return "Fizz";
        } else if ( n%5 == 0) {
            return "Buzz";
        } else if ( (n%3==0) && (n%5==0) ){
            return "FizzBuzz";
        }
        return String.valueOf(n);
    }

}
