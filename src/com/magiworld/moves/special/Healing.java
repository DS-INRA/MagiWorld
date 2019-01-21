package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Healing implements SpecialAttack {

    @Override
    public void performSpecialcAttack(Character attacker, Character target) {
        int healthGain = attacker.getIntelligence()*2;
        attacker.setCurrentHealth(attacker.getCurrentHealth()+healthGain);
    }
}
