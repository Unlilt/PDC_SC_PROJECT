/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.GameLogic.getInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class SaveGame {
     static void savePrompt(Player player) {
          String name = player.getName();
          String fileName = name + ".txt";
        File file = new File("./resources/" + fileName);
         if(file.exists()){
                System.out.println("You have an existing save. Overwrite it?");
                System.out.println("(1) Yes I'm sure!");
                System.out.println("(2) No, exit without saving.");
                 int input = getInput("->", 2);
                        if(input == 1)
                            saveInfoInitialize(player);
                                saveGame(file);
                                System.out.println("Thanks for Playing!");
            }
         else{
                    saveInfoInitialize(player);
                                saveGame(file); 
                                System.out.println("Thanks for Playing!");
}

    }
          protected static Map<String, String> playerInfo = new HashMap<>();

      
         public static void saveInfoInitialize(Player player) {

        playerInfo.put("NAME", player.getName()) ;
        playerInfo.put("MAXHP", String.valueOf(player.getMaxHP())) ;
        playerInfo.put("HP", String.valueOf(player.getHp())) ;
        playerInfo.put("XP", String.valueOf(player.getXp())) ;
        playerInfo.put("ROOMCOUNT", String.valueOf(player.roomCount)) ;



    }


      private static void saveGame(File fileName) {
//        String outputFile =player.getName() + ".txt";
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
//                    System.out.println();

            for (Map.Entry<String, String> entry : playerInfo.entrySet()) {
                // put key and value separated by a colon
                pw.write(entry.getKey() + ":"
                        + entry.getValue());
                // new line
                pw.println();
            }        

            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
