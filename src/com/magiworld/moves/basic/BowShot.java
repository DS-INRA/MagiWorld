package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class BowShot implements BasicAttack {
    @Override
    public String toString() {
        return "Tir à l\'arc";
    }

    /**
     * Rogues' basic attack : deals attacker's agility value of damages to target
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getAgility();
        System.out.println(attacker.getName()
                + " utilise "
                + this.toString()
                + " et inflige "
                + damages
                + " dégâts."
                );
        target.takeDamages(damages);
    }
}
