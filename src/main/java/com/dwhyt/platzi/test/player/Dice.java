package com.dwhyt.platzi.test.player;

import java.util.Random;

public class Dice {

    public int sides;

    public Dice (int sides){
        this.sides = sides;
    }

    public int roll(){
        return new Random().nextInt(sides) + 1;
    }


}
