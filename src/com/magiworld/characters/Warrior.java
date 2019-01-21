package com.magiworld.characters;

import com.magiworld.moves.basic.SwordHit;
import com.magiworld.moves.special.Rage;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.basicAttack = new SwordHit();
        this.specialAttack = new Rage();
    }
}
