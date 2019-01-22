package com.magiworld.moves.special;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealingTest {
    private Character attacker = new Mage("launcher", 10, 0, 0, 10);
    private Character target = new Mage("launcher", 10, 0, 0, 10);
    @Test
    public void Given_Healing_WhenLaunchedWithIntelligence10AndMoreThan20HealthLost_ThenRegain20Health(){
        attacker.setCurrentHealth(1);
        attacker.specialAttack.performSpecialAttack(attacker,target);
        assertEquals(21,attacker.getCurrentHealth());
    }

    @Test
    public void Given_Healing_WhenLaunchedWithIntelligence10AndLessThan20HealthLost_ThenRegainMaximumHealth(){
        attacker.setCurrentHealth(attacker.getCurrentHealth()-1);
        attacker.specialAttack.performSpecialAttack(attacker,target);
        assertEquals(attacker.getMaxHealth(),attacker.getCurrentHealth());
    }
}