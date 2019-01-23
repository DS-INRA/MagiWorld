package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class SwordHit implements BasicAttack {
    @Override
    public String toString() {
        return "Coup d'Épée";
    }

    /**
     * Warriors' basic attack : deals attacker's strength value of damages to target
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getStrength();
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
