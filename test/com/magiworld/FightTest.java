package com.magiworld;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FightTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Fight fight = new Fight();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    // Testing characterInitialization
    @Test
    public void Given_MageLevel9Strength1Agility0Intelligence8_When_CharacterIsInitialized_Then_InstanciateCorrectCharacter() {
        System.setIn(new ByteArrayInputStream("3\n9\n1\n0\n8\n".getBytes()));
        Character characterOne = null;
        Character model = new Mage("name",9,1,0,8);
        fight.characterInitialization(characterOne, "name");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(model,characterOne);
    }
    @Test
    public void Given_CharacterWithExcessiveArguments_When_CharacterIsInitialized_Then_ThrowExceptionExcessiveAttributesValue() {
        System.setIn(new ByteArrayInputStream("3\n9\n2\n2\n8\n".getBytes()));
        Character characterOne = null;
        fight.characterInitialization(characterOne, "name");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous devez saisir un nombre, correspondant au nombre de menus souhaités", output[12]);
    }

    // Testing stop
    @Test
    public void Given_OneDeadCharacter_When_StopIsRun_Then_DeadCharacterLoses(){
        List<Character> deads = new ArrayList<>();
        Character deadOne = new Mage("Dead 1",1,0,0,1);
        deadOne.setIsdead(true);
        deads.add(deadOne);
        String expectedString = "Fin de la partie :";
        String expectedString2 = "Dead 1 a perdu !";
        fight.stop(deads);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(expectedString,output[1]);
        assertEquals(expectedString2,output[2]);
    }

    @Test
    public void Given_TheTwoCharactersAreDead_When_StopIsRun_Then_ExAequo(){
        List<Character> deads = new ArrayList<>();
        Character deadOne = new Mage("Dead 1",1,0,0,1);
        deadOne.setIsdead(true);
        deads.add(deadOne);
        Character deadTwo = new Mage("Dead 2",1,0,0,1);
        deadTwo.setIsdead(true);
        deads.add(deadTwo);
        String expectedString = "Fin de la partie :";
        String expectedString2 = "Ex aequo, les deux personnages sont morts !";
        fight.stop(deads);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(expectedString,output[1]);
        assertEquals(expectedString2,output[2]);
    }

    // Testing Combat (start->combat->stop sequence)
    @Test
    public void Given_CombatSequence_When_StartIsRun_Then_GetToCorrectFightResult(){
        String inputs ="";
        inputs += "3\n50\n0\n0\n50"; // Create playerOne : Mage, lvl 50, 0 str, 0 ag, 50 int
        inputs += "1\n11\n11\n0\n0"; // Create playerTwo : Warrior, lvl 11, 11 str, 0 ag, 0 int
        inputs += "1"; // playerOne attacks
        inputs += "2"; // playerTwo sacrifices itself
        inputs += "n"; // no new game
        String expectedString = "Fin de la partie :";
        String expectedResult = "Joueur 2 a perdu !";
        System.setIn(new ByteArrayInputStream(inputs.getBytes()));
        fight.start("playerOne","playerTwo");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(expectedString,output[34]);
        assertEquals(expectedResult,output[35]);
    }

}