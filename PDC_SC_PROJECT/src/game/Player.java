/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.GameLogic.isRunning;
import java.util.Random;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Player extends Character{

    static void death(String killer) {
        GameLogic.clearConsole();
        System.out.println("You were killed by the " + killer + "! Evil Emperor Gnosis remains!");
        System.out.println("If you were to return to the past, would you succeed?");
        System.out.println("Thank you for playing!");
        isRunning = false;

    }

    static void win(Player pc, int xp) {
        pc.xp += xp;
        if(pc.xp >= 100){
        System.out.println("You levelled up! Your max hp increased by 10! Your hp was restored!");
        pc.maxHP += 10;
        pc.hp = pc.maxHP;
        pc.xp %= 100;
        }
    }
    public int roomCount = 0;
    Random rand = new Random();

    
    public Player(String name) {
       super(name, 100, 0, "Player");
       this.roomCount = 0;
    
    }

   
    
    public void rest(){
        GameLogic.clearConsole();
        System.out.println("You find a moment to compose yourself! \nThe determination running through you keeps you going.");
        int healed = rand.nextInt(this.maxHP/2);
        this.hp += healed;
        if(this.hp > this.maxHP){
            System.out.println("Your hp is restored to max!");
            this.hp = this.getMaxHP();
            GameLogic.anyKeyToContinue();

        }
        else{
        System.out.println("Your hp is restored by " + healed + " points!");
        GameLogic.anyKeyToContinue();
    }}
   
    
}
