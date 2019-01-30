package com.magiworld.characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Character testMage = new Mage("MrTest",10,0,0,10);
    private Character testRogue = new Rogue("MrTest",10,0,10,0);
    private Character testWarrior = new Warrior("MrTest",10,10,0,0);

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    // Testing takeDamages
    @Test
    public void Given_5DamagesDealtToCharacter_When_TakeDamagesIsRun_Then_CharacterLoses5Health(){
        testMage.takeDamages(5);
        assertEquals(45, testMage.getCurrentHealth());
    }

    @Test
    public void Given_MoreDamagesThanHealth_When_TakeDamagesIsRun_Then_CharacterDies(){
        testMage.takeDamages(666);
        assertEquals(true, testMage.isdead);
    }

    // Testing attack
    @Test
    public void Given_BasicAttackInStandardInput_When_MageAttacks_Then_AttackTypeIsCorrect(){
        testMage.attack(testMage,1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Boule de Feu"
                + " et inflige "
                + "10"
                + " dégâts.";
        assertEquals(expectedString,output[0]);
    }

    @Test
    public void Given_SpecialAttackInStandardInput_When_MageAttacks_Then_AttackTypeIsCorrect(){
        testMage.attack(testMage,2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Soin"
                + " et remonte à "
                + "50"
                + " points de vitalité.";
        assertEquals(expectedString,output[0]);
    }
    @Test
    public void Given_BasicAttackInStandardInput_When_RogueAttacks_Then_AttackTypeIsCorrect(){
        testRogue.attack(testRogue,1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Tir à l\'arc"
                + " et inflige "
                + "10"
                + " dégâts.";
        assertEquals(expectedString,output[0]);
    }

    @Test
    public void Given_SpecialAttackInStandardInput_When_RogueAttacks_Then_AttackTypeIsCorrect(){
        testRogue.attack(testRogue,2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Concentration"
                + " et gagne "
                + "5"
                + " en agilité.";
        assertEquals(expectedString,output[0]);
    }
    @Test
    public void Given_BasicAttackInStandardInput_When_WarriorAttacks_Then_AttackTypeIsCorrect(){
        testWarrior.attack(testWarrior,1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Coup d'Épée"
                + " et inflige "
                + "10"
                + " dégâts.";
        assertEquals(expectedString,output[0]);
    }

    @Test
    public void Given_SpecialAttackInStandardInput_When_WarriorAttacks_Then_AttackTypeIsCorrect(){
        testWarrior.attack(testWarrior,2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Coup de Rage"
                + " et inflige "
                + "20"
                + " dégâts...";
        String expectedString2 = "... mais il subit "
                + "5"
                + " dégâts.";
        assertEquals(expectedString,output[0]);
        assertEquals(expectedString2,output[1]);
    }
}