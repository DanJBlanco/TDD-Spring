package com.dwhyt.platzi.test.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void losses_when_dice_number_is_low(){
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice,2);

        assertEquals(false, player.play());
    }

    @Test
    public void win_when_dice_number_is_big(){
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice,3);

        assertEquals(true, player.play());
    }

}