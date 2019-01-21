package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class BowShot implements BasicAttack {
    /**
     * Rogues' basic attack : deals attacker's agility value of damages to target
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getAgility();
        target.setCurrentHealth(target.getCurrentHealth()-damages);
    }
}
