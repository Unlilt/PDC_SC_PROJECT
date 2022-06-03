/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
    
    public static GUI g;
    public static DBManager db;
    public static Connection conn;
    
//     static boolean  savePrompt(Player player) throws SQLException {
//         g = GameLogic.gameGui;
//         db = new DBManager();
//         conn = db.getConnection();
//          String name = player.getName();
//      
//         if((Player.ifPlayerExists(name))){
//                String overwrite = "You have an existing save. Overwrite it?";
//                System.out.println(overwrite);
//                g.saveText.setVisible(true);
//                g.yesBtnSave.setVisible(true);
//                g.noBtnSave.setVisible(true);
//
//            
//     
//         return true;
//            }
//         else{
////                    saveInfoInitialize(player);
//                                saveGame(player); 
//                                System.out.println("Thanks for Playing!");
//                                GameLogic.isRunning = false;
//                                 conn.close();
//         db.closeConnections();
//}
//         return false;
//        
//    }




      protected static synchronized void saveGame(Player pc) throws SQLException {
       
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
            System.out.println(pc.roomCount);

            pstmt.setInt(4, pc.xp);
            pstmt.setString(5, pc.name);
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
           pstmt.setString(1, pc.name);
           pstmt.setInt(2, pc.hp);
           pstmt.setInt(3, pc.maxHP);
           pstmt.setInt(4, pc.roomCount);
            System.out.println(pc.roomCount);
           pstmt.setInt(5, pc.xp);
           pstmt.execute();
        }
        pstmt.close();
        conn.close();
        db.closeConnections();
       
//        GameLogic.isRunning = false;
    }
      
}
