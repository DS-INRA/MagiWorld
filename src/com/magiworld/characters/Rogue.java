package com.magiworld.characters;

import com.magiworld.moves.basic.BowShot;
import com.magiworld.moves.special.Focus;

public class Rogue extends Character {

    public Rogue(String name, int level, int strength, int agility, int intelligence) {
        super(name, level, strength, agility, intelligence);
        this.basicAttack = new BowShot();
        this.specialAttack = new Focus();
    }

    @Override
    public String toString() {
        return "Shashasha, je suis le Rôdeur "+super.toString();
    }
}
