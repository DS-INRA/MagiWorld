package com.magiworld.moves.basic;

import com.magiworld.characters.Character;

public class FireBall implements BasicAttack {
    @Override
    public String toString() {
        return "Boule de Feu";
    }

    /**
     * Mages' Basic Attack : deals attacker's intelligence value of damages to target
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performBasicAttack(Character attacker, Character target) {
        int damages = attacker.getIntelligence();
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
