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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class SaveGame {
    public static DBManager db;
    public static Connection conn;
     static void savePrompt(Player player) throws SQLException {
         db = new DBManager();
         conn = db.getConnection();
          String name = player.getName();
          String fileName = name + ".txt";
        File file = new File("./resources/" + fileName);
         if((Player.ifPlayerExists(name))){
                System.out.println("You have an existing save. Overwrite it?");
                System.out.println("(1) Yes I'm sure!");
                System.out.println("(2) No, exit without saving.");
                 int input = getInput("->", 2);
                        if(input == 1)
//                            saveInfoInitialize(player);
                            saveGame(player);
                        System.out.println("Thanks for Playing!");
            }
         else{
//                    saveInfoInitialize(player);
//                                saveGame(file); 
                                System.out.println("Thanks for Playing!");
                                GameLogic.isRunning = false;
}
         conn.close();
         db.closeConnections();
    }
          protected static Map<String, String> playerInfo = new HashMap<>();

      
//         public static void saveInfoInitialize(Player player) {
//
//        playerInfo.put("NAME", player.getName()) ;
//        playerInfo.put("MAXHP", String.valueOf(player.getMaxHP())) ;
//        playerInfo.put("HP", String.valueOf(player.getHp())) ;
//        playerInfo.put("XP", String.valueOf(player.getXp())) ;
//        playerInfo.put("ROOMCOUNT", String.valueOf(player.roomCount)) ;
//
//
//
//    }


      private static void saveGame(Player pc) throws SQLException {
 
        db = new DBManager();
        conn = db.getConnection();
        Statement st = conn.createStatement();
        
        if(Player.ifPlayerExists(pc.name)){
        String updatePlayer = "UPDATE PLAYER SET HP=" + pc.hp+", MAXHP="+pc.maxHP+",ROOMNO= " + pc.roomCount +" WHERE NAME=" + pc.name.toUpperCase();
        st.execute(updatePlayer);
        }
        else{
            String addPlayer = "INSERT INTO PLAYER VALUES ("+ pc.name.toUpperCase()+", " +pc.hp+", "+ pc.xp+", "+ pc.roomCount+")";
            st.execute(addPlayer);
        }
        st.close();
        conn.close();
        db.closeConnections();
            
    }
      
}
