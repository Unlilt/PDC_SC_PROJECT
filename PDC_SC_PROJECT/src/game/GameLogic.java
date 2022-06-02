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
    
    //method to get user input from console
//    public static int getInput(String prompt, int choices) {
//        int input;
//        do{
//            System.out.println(prompt);
//            try{
//                input = Integer.parseInt(scanner.next());
//                
//            }catch(Exception e){
//                input = -1;
//                System.out.println("Please input an integer from the list of choices!");
//            }
//        }
//        while(input < 1 || input > choices);
//     return input;        
//    }
    

    
 
    
    //pause game until input to give user time to read
    public static void anyKeyToContinue(){
        System.out.println("\nEnter any key to continue...");
        scanner.next();
    }
    
    public static void Start() throws SQLException{
        //load map
//        Map.loadMap();
        //print title screen
//        clearConsole();
//        printPartition(40);
//        printPartition(30);
//        System.out.println("Adventurine!");
//        System.out.println("Text rpg by Jade Thompson-Tavai");
//        printPartition(30);
////        printPartition(40);
//        
//       String name = getName();
//        
       //call player constructor - constructor will verify if player already exists
        

        //print introduction
//        System.out.println("Your name is " + player.name + "!!");
       

        isRunning = true;
//        gameLoop();
    }
    
//    public static void gameLoop() throws SQLException{
//        while(isRunning){
//            
//            printMenu();
////            int input = getInput("->", 3);
//            switch(input){
//                case 1:
//                  continueAdventure();
//                  break;
//                case 2:
//                    displayCharacterInfo();
//                    break;
//                case 3:
//                    SaveGame.savePrompt(player);
//                    isRunning = false;
//                    break;
//                default:
//                    break;
//                           
//            }
//        }
//}
    public static String[] encounters = new String[] {"Battles", "Battles", "Battles", "Rest", "Rest"};
    public static String[] enemies = new String[] {"Goblin", "Troll", "HobGoblin"};
    
    
  
    public static void continueAdventure() {
        player.roomCount++;
        //If not in final boss room
        if(player.roomCount <= 5){
//            System.out.println(Map.getRoomDesc(player.roomCount));
//            anyKeyToContinue();

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
            System.out.println("This is it.");
            anyKeyToContinue();
            System.out.println("The final battle");
            anyKeyToContinue();
            System.out.println("(1) Yes! Bring it on!");
            System.out.println("(2)NO! TAKE ME HOME!");
            int input = getInput("->", 2);
            if(input == 2){
                clearConsole();
                System.out.println("Silly " + player.getName() + ", you're the hero.");
                anyKeyToContinue();
                clearConsole();
                System.out.println("You don't get a choice!");
                anyKeyToContinue();

            }
            clearConsole();
            System.out.println(Map.getRoomDesc(player.roomCount));
            anyKeyToContinue();
            Battle.finalBattle(player);
            System.out.println("Thank you for Playing!");
                    isRunning = false;

        }
    }

    private static void displayCharacterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println("MAX HP: " + player.getMaxHP());
        System.out.println("CURRENT HP: " + player.getHp());
        System.out.println("XP: " + player.getXp());
        printPartition(30);
        anyKeyToContinue();
    }

    private static void printMenu() {
        clearConsole();
        printHeading("MENU");
        System.out.println("What will you do?");
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
        printPartition(30);
    }

//    protected static String getName() {
//      String name;
//      boolean nameSet = false;
//        do{
//            clearConsole();
//            printHeading("What is your name?");
//            name = scanner.next();
//            
//            System.out.println("Is your name " + name + "?" );
//            System.out.println("(1) Yes!");
//            System.out.println("(2) No, I want to change my name.");
//            int input = getInput("->", 2);
//            if(input == 1)
//                nameSet = true;            
//        }
//        while(!nameSet); 
//            return name;
//
//    } 

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
