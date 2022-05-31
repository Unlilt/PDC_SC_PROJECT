/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.GameLogic.getInput;
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
    //if found save ask for confirmation to load
   static Player loadPrompt(File file, String name) throws SQLException {
       Player pc;
        System.out.println("We found a save file with this name. Load?");
        System.out.println("(1) Yes!");
        System.out.println("(2) No, I want to start a new game.");
        int input = getInput("->", 2);
        if(input == 1)
            //load confirmed
            pc = loadSave(name);
        else{
            //wants to start new game. Print warning
            System.out.println("If you save upon exit, you will overwrite the current save.");
            pc = new Player(name);
            GameLogic.anyKeyToContinue();
        }
        return pc;
    }

    public static Player loadSave(String name) throws SQLException {
             
//            try (BufferedReader inStream = new BufferedReader(new FileReader(file))) {
//                String line = null;
//                while((line=inStream.readLine())!=null){
//                    Scanner sc = new Scanner(line);
//                    sc.useDelimiter(",,*|\\. *|: *|\\*\\**");             
//                    while(sc.hasNext()){                                                      
//                        String next = sc.next();
//                        switch(next){
//                            
//                            case "NAME":
//                                next = sc.next();
//                                pc.name = (next);
//                                System.out.println(pc.name);
//                                break;
//
//                            case "MAXHP":
//                                next = sc.next();
//                                pc.maxHP = (Integer.parseInt(next));
//
//                                break;
//                            case "HP":
//                                next = sc.next();
//                                pc.hp = (Integer.parseInt(next));
//                                break;
//                            case "XP":
//                                next = sc.next();
//                                pc.xp = (Integer.parseInt(next));
//                                break;
//                            case "ID":
//                            next = sc.next();
//                            pc.setId(next);
//                            break;
//                            case "ROOMCOUNT":
//                                next = sc.next();
//                                pc.roomCount = Integer.parseInt(next);
//                                break;
//                            default:
//                                break;
//                        }
//                    
//                }}
//       } catch (FileNotFoundException ex) {
//           Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
//       } catch (IOException ex) {
//           Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
//       }
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
