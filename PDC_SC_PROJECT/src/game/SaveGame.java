/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.GameLogic.getInput;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class SaveGame {
    public static DBManager db;
    public static Connection conn;
     static boolean  savePrompt(Player player) throws SQLException {
         db = new DBManager();
         conn = db.getConnection();
          String name = player.getName();
          String fileName = name + ".txt";
        File file = new File("./resources/" + fileName);
         if((Player.ifPlayerExists(name))){
                System.out.println("You have an existing save. Overwrite it?");
                System.out.println("(1) Yes I'm sure!");
                System.out.println("(2) No, exit without saving.");
                //Input for testing
//                int input = 1;
                 int input = getInput("->", 2);
                        if(input == 1)
//                            saveInfoInitialize(player);
                            saveGame(player);
                        System.out.println("Thanks for Playing!");
                         conn.close();
         db.closeConnections();
         return true;
            }
         else{
//                    saveInfoInitialize(player);
//                                saveGame(file); 
                                System.out.println("Thanks for Playing!");
                                GameLogic.isRunning = false;
                                 conn.close();
         db.closeConnections();
}
         return false;
        
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


      private static synchronized void saveGame(Player pc) throws SQLException {
 
        db = new DBManager();
        conn = db.getConnection();
        PreparedStatement pstmt;
        if(Player.ifPlayerExists(pc.name)){
            /*set indexes
            hp = 1
            maxhp = 2
            roomno = 3
            xp = 4
            name = 5
            */
            pstmt = conn.prepareStatement("UPDATE PLAYER SET HP=?, MAXHP=?, ROOMNO=?, XP=? WHERE NAME=?");
            pstmt.setInt(1, pc.hp);
            pstmt.setInt(2, pc.maxHP);
            pstmt.setInt(3, pc.roomCount);
            pstmt.setInt(4, pc.xp);
            pstmt.setString(5, pc.name.toUpperCase());


        }
        else{
             /*set indexes
            name = 1
            hp = 2
            maxhp = 3
            roomno = 4
            xp = 5
            */
            pstmt = conn.prepareStatement("INSERT INTO PLAYER VALUES (?, ?, ?, ?, ?)");
           pstmt.setString(1, pc.name.toUpperCase());
           pstmt.setInt(2, pc.hp);
           pstmt.setInt(3, pc.maxHP);
           pstmt.setInt(4, pc.roomCount);
           pstmt.setInt(5, pc.xp);
           pstmt.execute();

        }
        pstmt.close();
        conn.close();
        db.closeConnections();
        GameLogic.isRunning = false;
    }
      
}
