package com.magiworld;

import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Rogue;
import com.magiworld.characters.Warrior;
import com.magiworld.exceptions.ExcessiveAttributesValue;

import java.util.*;

public class Fight {
    public Character playerOne;
    public Character playerTwo;

    public Scanner scanner = new Scanner(System.in);


    public Fight() {
    }

    /**
     * Initializes the two fighting characters and run fighting sequence
     * @param name1 First Character name
     * @param name2 Second Character name
     * @see characterInitialization()
     */
    public void start(String name1, String name2) {
        System.out.println("Création du personnage du Joueur 1");
        this.playerOne = characterInitialization(this.playerOne,name1);
        System.out.println("Création du personnage du Joueur 2");
        this.playerTwo = characterInitialization(this.playerTwo,name2);
        this.combat();

    }

    /**
     * Fighting loop :
     * while the characters are alive, first character then second character attack,
     * when one character is dead, calls stop() method to finish the fight
     * @see stop()
     */
    public void combat(){
        List<Character> deads = new ArrayList<>();
        int attackType=0;
        while (!(this.playerOne.getIsDead()||this.playerTwo.getIsDead())){
            // First player turn
            do {
                System.out.println(playerOne.getName()+" ("+playerOne.getCurrentHealth()+" vitalité) Veuillez choisir votre action (1: Attaque basique, 2 : Attaque Spéciale)");
                try {
                    attackType = scanner.nextInt();
                } catch (InputMismatchException e){
                    scanner.next();
                }
            } while (!(attackType==1 || attackType ==2));
            playerOne.attack(playerTwo,attackType);
            if (playerOne.getIsDead())
                deads.add(playerOne);
            if (playerTwo.getIsDead())
                deads.add(playerTwo);
            if (!(this.playerOne.getIsDead()||this.playerTwo.getIsDead())){
                // Second player turn
                do {
                    System.out.println(playerTwo.getName()+" ("+playerTwo.getCurrentHealth()+" vitalité) Veuillez choisir votre action (1: Attaque basique, 2 : Attaque Spéciale)");
                    try {
                        attackType = scanner.nextInt();
                    } catch (InputMismatchException e){
                        scanner.next();
                    }
                } while (!(attackType==1 || attackType ==2));
                playerTwo.attack(playerOne,attackType);
                if (playerOne.getIsDead())
                    deads.add(playerOne);
                if (playerTwo.getIsDead())
                    deads.add(playerTwo);
            }
        }
        stop(deads);
    }

    /**
     * Displays the result of the fight (ex aequo if both characters are dead)
     * @param deads the killed characters during the fight
     */
    public void stop(List<Character> deads){
        // Result of the fight
        System.out.println("");
        System.out.println("Fin de la partie :");
        if (deads.size()==1)
            System.out.println(deads.get(0).getName()+" a perdu !");
        else if (deads.size()==2)
            System.out.println("Ex aequo, les deux personnages sont morts !");
    }

    /**
     * Initialisation of one fighting character via player console inputs.
     * @param character the character to initialize
     * @param name the name of the character
     */
    public Character characterInitialization(Character character,String name){
        Map<String,Integer> attributes = new HashMap<String,Integer>();
        int attributeValue;
        // Class Choice
        do {
            attributeValue = 0;
            System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage");
            try {
                attributeValue = scanner.nextInt();
                attributes.put("class",attributeValue);
            } catch (InputMismatchException e) {
                System.out.println("Veuillez saisir un nombre !");
                scanner.next();
            }
        } while (!(attributeValue == 1 || attributeValue == 2 || attributeValue == 3));
        // Level choice
        do {
            attributeValue = -1;
            System.out.println("Niveau du joueur (0-100)");
            try {
                attributeValue = scanner.nextInt();
                attributes.put("level",attributeValue);
            } catch (InputMismatchException e){
                System.out.println("Veuillez saisir un nombre !");
                scanner.next();
            }
        } while (!(0 < attributeValue && attributeValue <= 100));
        // Strength, Agility and Intelligence
        // Total of the three must not excede level value.
        //int cumulatedStrengthAgilityIntelligence = 0;
        boolean validAttributes;
        int cumulatedStrengthAgilityIntelligence;
        do {
            validAttributes = true;
            cumulatedStrengthAgilityIntelligence = 0;
            try {
                // Strength
                System.out.println("Force du personnage");
                int strengthValue = scanner.nextInt();
                cumulatedStrengthAgilityIntelligence += strengthValue;
                if (cumulatedStrengthAgilityIntelligence > attributes.get("level"))
                    throw new ExcessiveAttributesValue();
                // Agility
                System.out.println("Agilité du personnage");
                int agilityValue = scanner.nextInt();
                cumulatedStrengthAgilityIntelligence += agilityValue;
                if (cumulatedStrengthAgilityIntelligence > attributes.get("level"))
                    throw new ExcessiveAttributesValue();
                // Intelligence
                System.out.println("Intelligence du personnage");
                int intelligenceValue = scanner.nextInt();
                cumulatedStrengthAgilityIntelligence += intelligenceValue;
                if (cumulatedStrengthAgilityIntelligence > attributes.get("level"))
                    throw new ExcessiveAttributesValue();
                // Saving
                attributes.put("strength",strengthValue);
                attributes.put("agility",agilityValue);
                attributes.put("intelligence",intelligenceValue);
            } catch (InputMismatchException e1){
                System.out.println("Veuillez saisir un nombre !");
                scanner.next();
                validAttributes = false;
            }
            catch (ExcessiveAttributesValue e2){
                System.out.println("Le total de Force + Agilité + Intelligence ne doit pas dépasser le niveau du personnage !");
                validAttributes = false;
            }
        } while(!validAttributes);
        // Character instantiation
        switch (attributes.get("class")){
            //String name, int level, int strength, int agility, int intelligence
            case 1 :
                character = new Warrior(name,
                        attributes.get("level"),
                        attributes.get("strength"),
                        attributes.get("agility"),
                        attributes.get("intelligence"));
                break;
            case 2 :
                character = new Rogue(name,
                        attributes.get("level"),
                        attributes.get("strength"),
                        attributes.get("agility"),
                        attributes.get("intelligence"));
                break;
            case 3 :
                character = new Mage(name,
                        attributes.get("level"),
                        attributes.get("strength"),
                        attributes.get("agility"),
                        attributes.get("intelligence"));
                break;
        }
        // Visualization
        System.out.println(character.toString());

        return character;
    }

}
