package com.magiworld.characters;

import com.magiworld.moves.basic.BowShot;
import com.magiworld.moves.special.Focus;

public class Rogue extends Character {

    public Rogue(String name) {
        super(name);
        this.basicAttack = new BowShot();
        this.specialAttack = new Focus();
    }
}
