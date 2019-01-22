package com.magiworld.moves.basic;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordHitTest {
    public BasicAttack fireBall = new FireBall();
    public Character attacker = new Warrior("launcher", 10, 10, 0, 0);
    private Character target = new Mage("launcher", 10, 0, 0, 10);

    @Test
    public void Given_SwordHit_WhenAttackedWithStrength10_ThenLose10Health(){
        attacker.basicAttack.performBasicAttack(attacker,target);
        assertEquals(40,target.getCurrentHealth());
    }
}