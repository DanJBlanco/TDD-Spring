/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwhyt.platzi.test.util;

/**
 *
 * @author Dany
 */
public class PasswordUtil {
    
    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }
    
    public static SecurityLevel assessPassword( String password){

        if(password.length() < 8){
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
