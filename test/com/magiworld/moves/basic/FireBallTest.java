package com.magiworld.moves.basic;

import com.magiworld.characters.*;
import com.magiworld.characters.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireBallTest {
    public Character attacker = new Mage("launcher", 10, 0, 0, 10);
    private Character target = new Mage("launcher", 10, 0, 0, 10);

    @Test
    public void Given_FireBall_WhenAttackedWithIntelligence10_ThenLose10Health(){
        attacker.basicAttack.performBasicAttack(attacker,target);
        assertEquals(40,target.getCurrentHealth());
    }

}