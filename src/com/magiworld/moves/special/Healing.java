package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Healing implements SpecialAttack {
    /**
     * Mages' special attack : restore twice intelligence value of health, health points cannot excede starting health points value.
     * @param attacker character restoring its health
     * @param target unused here
     */
    @Override
    public void performSpecialAttack(Character attacker, Character target) {
        int healthGain = attacker.getIntelligence()*2;
        int newHealth = attacker.getCurrentHealth()+healthGain;
        if (newHealth>attacker.getMaxHealth())
            newHealth = attacker.getMaxHealth();
        attacker.setCurrentHealth(newHealth);
    }
}
