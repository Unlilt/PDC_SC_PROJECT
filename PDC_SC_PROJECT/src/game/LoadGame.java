/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class LoadGame {
   public static Connection conn;
    public static DBManager db;
    

    public static Player loadSave(String name) throws SQLException {
            Player pc = new Player(name);
            db = new DBManager();
            conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PLAYER WHERE NAME = ?");
            pstmt.setString(1, name.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            pc.hp = rs.getInt("HP");
            pc.maxHP = rs.getInt("MAXHP");
            pc.roomCount = rs.getInt("ROOMNO");
            pc.xp = rs.getInt("XP");
            }
            pstmt.close();
            conn.close();
            db.closeConnections();
            return pc;
    }}
