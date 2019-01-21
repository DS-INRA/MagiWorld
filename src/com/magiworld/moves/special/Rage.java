package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Rage implements SpecialAttack {

    @Override
    public void performSpecialcAttack(Character attacker, Character target) {
        int damagesEnnemy = attacker.getStrength()*2;
        int damagesSelf = attacker.getStrength()/2;
        target.setCurrentHealth(target.getCurrentHealth() - damagesEnnemy);
        attacker.setCurrentHealth(attacker.getCurrentHealth() - damagesSelf);
    }
}
