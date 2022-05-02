/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public abstract class Character {
    
    protected String name;
    protected int maxHP, hp, xp;
    private String id;

    public void setId(String id) {
        this.id = id;
    }
    
    //constructor
    public Character(String name, int maxHP, int xp, String id){

        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.hp = maxHP;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getHp() {
        return this.hp;
    }

    public int getXp() {
        return this.xp;
    }

    public String getId() {
        return this.id;
    }
     
    
}
