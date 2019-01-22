package com.magiworld.moves.special;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RageTest {
    private Character attacker = new Warrior("launcher", 10, 10, 0, 0);
    private Character target = new Mage("launcher", 10, 0, 0, 10);
    @Test
    public void Given_Focus_WhenLaunchedWithStrength10_ThenLose5HealthAndDeal20Damages(){
        attacker.specialAttack.performSpecialAttack(attacker,target);
        assertEquals(45,attacker.getCurrentHealth());
        assertEquals(30,target.getCurrentHealth());
    }
}