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
public class Enemy extends Character {
      
    public Enemy(String name, int hp, int xp){
        super(name, hp, xp, "ENEMY" );
    }

    static Enemy summonMonster(String enemy) {
        System.out.println("A " + enemy + " appears! You must fight them to pass!");
        System.out.println("The battle begins!");
        
        //create enemy number from randomized enemyarray in GL
        Enemy monster = null;
        switch(enemy){
            case "Goblin":
                monster = new Enemy("Goblin", 20, 40);
                break;
             case "Troll":
                monster = new Enemy("Troll", 30, 60);
                break;   
             case "HobGoblin":
                monster = new Enemy("HobGoblin", 25, 50);
                break;   
        }
                return monster;

    }   
}
