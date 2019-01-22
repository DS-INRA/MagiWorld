package com.magiworld.moves.basic;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Rogue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowShotTest {
    public Character attacker = new Rogue("launcher", 10, 0, 10, 0);
    private Character target = new Mage("launcher", 10, 0, 0, 10);

    @Test
    public void Given_BowShot_WhenAttackedWithAgility10_ThenLose10Health(){
        attacker.basicAttack.performBasicAttack(attacker,target);
        assertEquals(40,target.getCurrentHealth());
    }
}