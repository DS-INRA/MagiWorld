package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class SwordHit implements BasicAttack {
    /**
     * Warriors' basic attack : deals attacker's strength value of damages to target
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getStrength();
        target.setCurrentHealth(target.getCurrentHealth()-damages);
    }
}
