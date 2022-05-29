/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;
    
    //method to get user input from console
    public static int getInput(String prompt, int choices) {
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
                
            }catch(Exception e){
                input = -1;
                System.out.println("Please input an integer from the list of choices!");
            }
        }
        while(input < 1 || input > choices);
     return input;        
    }
    
    //simulates clearing previous text from screen
    public static void clearConsole(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
    
    //method to print separators between choices and other text etc using length n
    public static void printPartition(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();

    }
    
    public static void printHeading(String title){
        printPartition(30);
        System.out.println(title);
        printPartition(30);
    }
    
    //pause game until input to give user time to read
    public static void anyKeyToContinue(){
        System.out.println("\nEnter any key to continue...");
        scanner.next();
    }
    
    public static void Start() throws SQLException{
        //load map
        Map.loadMap();
        //print title screen
        clearConsole();
        printPartition(40);
        printPartition(30);
        System.out.println("Adventurine!");
        System.out.println("Text rpg by Jade Thompson-Tavai");
        printPartition(30);
        printPartition(40);
        
       String name = getName();
        
       //check if file already exists
        File file = new File("./resources/" + name + ".txt");
        //if yes
        if(file.exists()){
            player = LoadGame.loadPrompt(file, name);
        }
        //if no
        else{
        player = new Player(name);
        }

        //print introduction
        System.out.println("Your name is " + name + "!!");
       if(player.roomCount == 0){
                       clearConsole();
            System.out.println(Map.getRoomDesc(0));
            anyKeyToContinue();
            }

        isRunning = true;
        gameLoop();
    }
    
    public static void gameLoop(){
        while(isRunning){
            
            printMenu();
            int input = getInput("->", 3);
            switch(input){
                case 1:
                  continueAdventure();
                  break;
                case 2:
                    displayCharacterInfo();
                    break;
                case 3:
                    SaveGame.savePrompt(player);
                    isRunning = false;
                    break;
                default:
                    break;
                           
            }
        }
}
    public static String[] encounters = new String[] {"Battles", "Battles", "Battles", "Rest", "Rest"};
    public static String[] enemies = new String[] {"Goblin", "Troll", "HobGoblin"};
    
    private static void continueAdventure() {
        player.roomCount++;
        //If not in final boss room
        if(player.roomCount <= 5){
            clearConsole();
            System.out.println(Map.getRoomDesc(player.roomCount));
            anyKeyToContinue();

            //Create random encounter
            Random rand = new Random();
            int num = rand.nextInt(5);
            String encounter;
            encounter = encounters[num];
            switch(encounter){
                case "Battles":
                    clearConsole();
                    int numEnemy = rand.nextInt(3);
                    Enemy enemy = Enemy.summonMonster(enemies[numEnemy]);
                    anyKeyToContinue();
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
            clearConsole();
            System.out.println("This is it.");
            anyKeyToContinue();
            clearConsole();
            System.out.println("The final battle");
            anyKeyToContinue();
            clearConsole();
            printHeading("ARE YOU READY?");
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

    protected static String getName() {
      String name;
      boolean nameSet = false;
        do{
            clearConsole();
            printHeading("What is your name?");
            name = scanner.next();
            
            System.out.println("Is your name " + name + "?" );
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = getInput("->", 2);
            if(input == 1)
                nameSet = true;            
        }
        while(!nameSet); 
            return name;

    } 
    }
