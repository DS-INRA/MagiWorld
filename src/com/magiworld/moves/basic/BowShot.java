package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class BowShot implements BasicAttack {
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getAgility();
        target.setCurrentHealth(target.getCurrentHealth()-damages);
    }
}
