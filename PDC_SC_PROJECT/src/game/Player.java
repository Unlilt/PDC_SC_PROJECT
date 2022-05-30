/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.GameLogic.isRunning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Player extends Character{
    public static Connection conn;
    public static DBManager db;
    
    static void death(String killer) {
        GameLogic.clearConsole();
        System.out.println("You were killed by the " + killer + "! Evil Emperor Gnosis remains!");
        System.out.println("If you were to return to the past, would you succeed?");
        System.out.println("Thank you for playing!");
        isRunning = false;

    }

    static void win(Player pc, int xp) {
        pc.xp += xp;
        if(pc.xp >= 100){
        System.out.println("You levelled up! Your max hp increased by 10! Your hp was restored!");
        pc.maxHP += 10;
        pc.hp = pc.maxHP;
        pc.xp %= 100;
        }
    }
    public int roomCount = 0;
    Random rand = new Random();

    
    public Player(String name) throws SQLException {
       super(name, 100, 0, "Player");
       this.roomCount = 0;
        db = new DBManager();
        conn = db.getConnection();
        Statement st = conn.createStatement();
        if(!db.ifTableExists("PLAYER")){
            createPlayerTable();
        }
      
            
            String addPlayer = "INSERT INTO PLAYER VALUES(" + name.toUpperCase() + ",100,100, 0, 0)";
            st.execute(addPlayer);
        
        st.close();
        conn.close();
        db.closeConnections();
        }

   
    
    public void rest(){
        GameLogic.clearConsole();
        System.out.println("You find a moment to compose yourself! \nThe determination running through you keeps you going.");
        int healed = rand.nextInt(this.maxHP/2);
        this.hp += healed;
        if(this.hp > this.maxHP){
            System.out.println("Your hp is restored to max!");
            this.hp = this.getMaxHP();
            GameLogic.anyKeyToContinue();

        }
        else{
        System.out.println("Your hp is restored by " + healed + " points!");
        GameLogic.anyKeyToContinue();
    }}

    private void createPlayerTable() throws SQLException {
        db = new DBManager();
        conn = db.getConnection();
        Statement st = conn.createStatement();
        
        String createTable = "CREATE TABLE PLAYER(NAME VARCHAR(50), HP INT, MAXHP INT, XP INT, ROOMNO INT)";
        st.execute(createTable);
        st.close();
        db.closeConnections();
    }
   
    public static boolean ifPlayerExists(String name) throws SQLException{
        db = new DBManager();
        conn = db.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PLAYER WHERE NAME = " + name.toUpperCase());
        
        return rs.next();
    }
    
}
