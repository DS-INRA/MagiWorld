package com.magiworld.characters;

import com.magiworld.moves.basic.BasicAttack;
import com.magiworld.moves.special.SpecialAttack;

public abstract class Character{
    String name;
    BasicAttack basicAttack;
    SpecialAttack specialAttack;
    int level;
    int maxHealth;
    int currentHealth;
    int strength;
    int agility;
    int intelligence;

    public Character() {

    }

    public Character(int level, int strength, int agility, int intelligence){
        this.level = level;
        this.maxHealth = level*5;
        this.currentHealth = level*5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

/*    public void attack(Character target){
        int typeOfAttack = 0;
        // Ask user type of attack
        do {
            System.out.println("Choisissez une attaque (1 : basique, 2 : spéciale)");
            //Scan user choice

            // Perform selected attack
            if (typeOfAttack ==1)
                this.basicAttack.performBasicAttack(this, target);
            else if (typeOfAttack ==2)
                this.specialAttack.performSpecialcAttack(this,target);
        } while (typeOfAttack !=1 || typeOfAttack !=2);
    }*/
}
