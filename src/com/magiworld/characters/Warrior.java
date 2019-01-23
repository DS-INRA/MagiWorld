package com.magiworld.characters;

import com.magiworld.moves.basic.SwordHit;
import com.magiworld.moves.special.Rage;

public class Warrior extends Character {

   public Warrior(String name, int level, int strength, int agility, int intelligence) {
        super(name, level, strength, agility, intelligence);
        this.basicAttack = new SwordHit();
        this.specialAttack = new Rage();
    }

    @Override
    public String toString() {
        return "Woarg, je suis le Guerrier "+super.toString();
    }
}
