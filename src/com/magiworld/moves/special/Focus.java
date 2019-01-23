package com.magiworld.moves.special;

import com.magiworld.characters.Character;

public class Focus implements SpecialAttack {
    @Override
    public String toString() {
        return "Concentration";
    }

    /**
     * Rogues' special attack : improve attacker's agility by half his level value.
     * @param attacker character improving its agility
     * @param target unused here
     */
    @Override
    public void performSpecialAttack(Character attacker, Character target) {
        int agilityGain = attacker.getLevel()/2;
        System.out.println(attacker.getName()
                + " utilise "
                + this.toString()
                + " et gagne "
                + agilityGain
                + " en agilité."
        );
        attacker.setAgility(attacker.getAgility()+agilityGain);


    }
}
