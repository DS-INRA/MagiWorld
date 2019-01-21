package com.magiworld.characters;

import com.magiworld.moves.basic.FireBall;
import com.magiworld.moves.special.Healing;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
        this.basicAttack = new FireBall();
        this.specialAttack = new Healing();
    }
}
