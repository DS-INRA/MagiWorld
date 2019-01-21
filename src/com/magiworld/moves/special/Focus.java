package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Focus implements SpecialAttack {

    @Override
    public void performSpecialcAttack(Character attacker, Character target) {
        int agilityGain = attacker.getLevel()/2;
        attacker.setAgility(attacker.getAgility()+agilityGain);
    }
}
