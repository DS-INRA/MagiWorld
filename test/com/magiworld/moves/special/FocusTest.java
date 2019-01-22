package com.magiworld.moves.special;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Rogue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FocusTest {
    public Character attacker = new Rogue("launcher", 10, 0, 10, 0);
    private Character target = new Mage("launcher", 10, 0, 0, 10);
    @Test
    public void Given_Focus_WhenLaunchedWithLevel10_ThenGain5Agility(){
        attacker.specialAttack.performSpecialAttack(attacker,target);
        assertEquals(15,attacker.getAgility());
    }
}