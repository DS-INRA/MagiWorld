package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Focus implements SpecialAttack {
    /**
     * Rogues' special attack : improve attacker's agility by half his level value.
     * @param attacker character improving its agility
     * @param target unused here
     */
    @Override
    public void performSpecialcAttack(Character attacker, Character target) {
        int agilityGain = attacker.getLevel()/2;
        attacker.setAgility(attacker.getAgility()+agilityGain);
    }
}
