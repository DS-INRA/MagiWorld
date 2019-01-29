package com.magiworld.characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Character testCharacter = new Mage("MrTest",10,0,0,10);

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
        testCharacter.takeDamages(5);
        assertEquals(45,testCharacter.getCurrentHealth());
    }

    @Test
    public void Given_MoreDamagesThanHealth_When_TakeDamagesIsRun_Then_CharacterDies(){
        testCharacter.takeDamages(666);
        assertEquals(true, testCharacter.isdead);
    }

    // Testing attack
    @Test
    public void Given_BasicAttackInStandardInput_When_CharacterAttacks_Then_AttackTypeIsCorrect(){
        testCharacter.attack(testCharacter,1);
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
    public void Given_SpecialAttackInStandardInput_When_CharacterAttacks_Then_AttackTypeIsCorrect(){
        testCharacter.attack(testCharacter,2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        String expectedString = "MrTest"
                + " utilise "
                + "Soin"
                + " et remonte à "
                + "50"
                + " points de vitalité.";
        assertEquals(expectedString,output[0]);
    }

}