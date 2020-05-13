/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwhyt.platzi.test;
import com.dwhyt.platzi.test.util.PasswordUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.dwhyt.platzi.test.util.PasswordUtil.SecurityLevel.*;

/**
 *
 * @author Dany
 */
public class PasswordUtilTest {


    @Test
    public void weak_when_has_less_8_letter(){
        assertEquals(WEAK, PasswordUtil.assessPassword("123asd!"));
    }

    @Test
    public void weak_when_has_only_letter(){
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letter_and_number(){
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols(){
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123!"));
    }
    
}
