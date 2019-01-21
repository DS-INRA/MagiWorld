package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class SwordHit implements BasicAttack {

    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getStrength();
        target.setCurrentHealth(target.getCurrentHealth()-damages);
    }
}
