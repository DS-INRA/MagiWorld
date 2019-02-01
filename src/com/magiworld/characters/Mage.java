package com.magiworld.characters;

import com.magiworld.moves.basic.FireBall;
import com.magiworld.moves.special.Healing;

public class Mage extends Character {

    public Mage(String name, int level, int strength, int agility, int intelligence) {
        super(name, level, strength, agility, intelligence);
        this.basicAttack = new FireBall();
        this.specialAttack = new Healing();
    }

    @Override
    public String toString() {
        return "Abracadabra, je suis le Mage "+super.toString();
    }
}
