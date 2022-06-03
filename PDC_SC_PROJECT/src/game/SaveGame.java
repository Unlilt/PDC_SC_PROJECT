/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class SaveGame {
    
    public static GUI g;
    public static DBManager db;
    public static Connection conn;
    
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
