/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class GameLogic implements Runnable {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;
    public static GUI gameGui;
    
    public GameLogic(){
              gameGui = new GUI();
            //Create/initialize GUI
            JFrame window = gameGui;
            window.setPreferredSize(new Dimension(800, 600));
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            window.setContentPane(gameGui);
            window.pack();
            window.setVisible(true);

            
    }
    
    public static void setPlayer(String name) throws SQLException{
        player = new Player(name);
    }
 
    
    public static void Start() throws SQLException{

        isRunning = true;
    }
    

    public static String[] encounters = new String[] {"Battles", "Battles", "Battles", "Rest", "Rest"};
    public static String[] enemies = new String[] {"Goblin", "Troll", "HobGoblin"};
    
    
  
    public static void continueAdventure() {
        player.roomCount++;
        //If not in final boss room
        if(player.roomCount <= 5){

            //Create random encounter
            Random rand = new Random();
            int num = rand.nextInt(5);
            String encounter;
            encounter = encounters[num];
            switch(encounter){
                case "Battles":
                    int numEnemy = rand.nextInt(3);
                    Enemy enemy = Enemy.summonMonster(enemies[numEnemy]);
                    Battle.startBattle(player, enemy );
                    break;
                case "Rest":
                    player.rest();
                    break;
                default:
                    break;
            }  
        }
        //If player is going in to final room
        if(player.roomCount > 5){
            gameGui.bossBattle();
            Battle.finalBattle(player);
            }
    }

    @Override
    public void run() {
        try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Start();
        } catch (SQLException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
