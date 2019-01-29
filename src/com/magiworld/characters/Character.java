package com.magiworld.characters;

import com.magiworld.moves.basic.BasicAttack;
import com.magiworld.moves.special.SpecialAttack;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public abstract class Character{
    protected String name;
    public BasicAttack basicAttack;
    public SpecialAttack specialAttack;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected boolean isdead;

    public Character(String name, int level, int strength, int agility, int intelligence) {
        this.name = name;
        this.level = level;
        this.maxHealth = level*5;
        this.currentHealth = level*5;
        this.strength = strength;
        this.agility = agility;
        this. intelligence = intelligence;
        this.isdead = false;
    }

    @Override
    public String toString() {
        return this.name
                + " de niveau " + this.level + ". "
                + "Je possède "
                + this.currentHealth + " de vitalité, "
                + this.strength + " de force, "
                + this.agility + " d'agilité et "
                + this.intelligence + " d\'intelligence !"
                ;
    }

    // GETTERS
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public int getCurrentHealth() { return currentHealth; }
    public int getLevel() { return level; }
    public int getMaxHealth() { return maxHealth; }
    public String getName() { return name; }

    // SETTERS
    public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    // OTHER METHODS
    /**
     * Perform the character basic or special attack.
     * @param target the target of the attack.
     * @param typeOfAttack 1 for a basic attack, 2 for a special attack.
     */
    public void attack(Character target, int typeOfAttack){
            if (typeOfAttack ==1)
                this.basicAttack.performBasicAttack(this, target);
            else if (typeOfAttack ==2)
                this.specialAttack.performSpecialAttack(this,target);
    }

    /**
     * Resolves damages from an attack and checks if the character survives.
     * @param damages The amount of damages received.
     */
    public void takeDamages(int damages){
        this.currentHealth = this.currentHealth - damages;
        if (this.currentHealth <= 0)
            this.isdead = true;
        System.out.println(this.getName()+" est mort");
    }
}
