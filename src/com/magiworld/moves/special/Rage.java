package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Rage implements SpecialAttack {
    @Override
    public String toString() {
        return "Coup de Rage";
    }

    /**
     * Warriors' special attack : deals twice strength value of damages but deals half strength value of damages to self.
     * @param attacker character launching the atack
     * @param target character facing the attack
     */
    @Override
    public void performSpecialAttack(Character attacker, Character target) {
        int damagesEnnemy = attacker.getStrength()*2;
        int damagesSelf = attacker.getStrength()/2;
        System.out.println(attacker.getName()
                + " utilise "
                + this.toString()
                + " et inflige "
                + damagesEnnemy
                + " dégâts..."
        );
        target.takeDamages(damagesEnnemy);
        System.out.println("... mais il subit "
                + damagesSelf
                + " dégâts."
        );
        attacker.takeDamages(damagesSelf);
    }
}
