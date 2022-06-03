/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public static GUI g;
    public static int roomCount = 0;
    Random rand = new Random();
    
    static void death(String killer) {
        g = GameLogic.gameGui;
        String death = "";
        death+="You were killed by the " + killer + "! Evil Emperor Gnosis remains!";
        death+="If you were to return to the past, would you succeed?";
        death+="Thank you for playing!";
        g.battleText.setText(death);

    }

    static void win(Player pc, int xp) {
        g = GameLogic.gameGui;
        pc.xp += xp;
        if(pc.xp >= 100){
        String levelUp = "You levelled up! Your max hp increased by 10! Your hp was restored!";
        g.textArea.setText(levelUp);
        pc.maxHP += 10;
        pc.hp = pc.maxHP;
        pc.xp %= 100;
        }
    }
 

    
    public Player(String name) throws SQLException {
       super(name, 100, 0, "Player");
       roomCount = 0;
        db = new DBManager();
        
             
        if(!db.ifTableExists("PLAYER")){
            createPlayerTable();
        }
      
        if(!ifPlayerExists(name)){
            insertIntoDb(name);
        }
       
            
        
        db.closeConnections();
        }

   
    
    public void rest(){
          g = GameLogic.gameGui;

        String rest = "You find a moment to compose yourself! \nThe determination running through you keeps you going.";
        
        int healed = rand.nextInt(this.maxHP/2);
        this.hp += healed;
        if(this.hp > this.maxHP){
            rest+="Your hp is restored to max!";
            this.hp = this.getMaxHP();

        }
        else{
        rest+=("Your hp is restored by " + healed + " points!");
        g.textArea.setText(rest);
        
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
     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PLAYER WHERE NAME = ? ");
     stmt.setString(1, name.toUpperCase());
     ResultSet rs = stmt.executeQuery();
     
        return rs.next();
    }

    private void insertIntoDb(String name) throws SQLException {
        db = new DBManager();
        conn = db.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO PLAYER (NAME, HP, MAXHP, XP, ROOMNO) VALUES(?,100,100, 0, 0)");
            stmt.setString(1, name.toUpperCase());
            stmt.execute();
            stmt.close();    
    
            conn.close();
        db.closeConnections();
    }
    
}
