/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
class Map {
        public static DBManager db;
        public static Connection conn;
        
        public Map(){
            db = new DBManager();
//            try {
//                createMap();
//            } catch (SQLException ex) {
//                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        
           //Read from DB
        public static String getRoomDesc(int key) throws SQLException {
              conn = db.getConnection();
              Statement st = conn.createStatement();
              String getDesc = "SELECT DESCRIPTION FROM MAP WHERE ROOMNO = " + key;
              ResultSet rs = st.executeQuery(getDesc);
              String desc = rs.getNString("DESCRIPTION");
              System.out.println(desc);
            return desc;
        }

    
    //Create table if not currently exists
    //returns true if created, false if already exists
    public boolean  createMap() throws SQLException{
        conn = db.getConnection();

        if( !ifExists( conn, "MAP") ){
            Statement st = conn.createStatement();
            String createTable = "CREATE TABLE MAP(ROOMNO INT, DESCRIPTION VARCHAR(250))";
            st.execute(createTable);
            String intro = "INSERT INTO MAP VALUES (0, You are a brave hero who has been captured by the evil emperor Gnosis! "
                    + "Thrown into the dungeon of his castle to rot, you plot an escape.\n" +
                    "One day, a large explosion rock the castle, rubble falling into your chamber. The force has knocked loose the cage door from the stone!\n" +
                    "This is your chance!\n" +
                    "Onward brave hero!) ";
            String room1 = "INSERT INTO MAP VALUES (1, The Interior of this room is empty, save for a single stone slab pushed into a corner. A bed.\n" +
                   "Light streams through slotted iron bars in a window.\n" +
                   "The door is slightly ajar.)";
            String room2 = "INSERT INTO MAP VALUES (2,You are in a dark hallway. There are no windows, only the faint light from torches lining the stone walls. \n" +
                    "A massive pair of worn statues in a misty swamp marks the entrance to the next room. \n" +
                    "Beyond the pair of worn statues lies a massive, filthy room. It's covered in broken pottery, large bones and crawling insects.\n" +
                    "The torches allow you to see broken vats and flasks, forgotten and ravaged by time itself.)";
            String room3 = "INSERT INTO MAP VALUES (3, The hair on the back of your neck stands as you enter a homely hexagonal room. \n" +
                   "Blood stains line the reinforced metallic walls. Blood stains cover the fractured floor. \n" +
                   "Moss that lines the wall seems to be glowing, giving off a mysterious light. \n" +
                   "There are no other exits, but there is a large crack in the wall that leads to another room.)";
            String room4 = "INSERT INTO MAP VALUES(4, As you squeeze through the crack in the wall, you enter a smaller, dilapidated room.\n" +
                   "There are bookshelves lining the walls, and a desk in the centre. A broken oil lamp lies discarded on the stone floor.\n" +
                   "You can feel eyes on your, but there is no one there.)";
            String room5 = "INSERT INTO MAP VALUES(5, Moving past the scattered papers and the broken lamp, you find a door. It is half behind a fallen bookcase.\n" +
                   "Squeezing through the small opening, you find yourself in a large, ornate room. A ballroom perhaps?\n" +
                   "The curtains are torn from the windows, some glass panes shattered. The moonlight streaks in, casting shadows on the portraits opposite.\n" +
                   "The stares on your back intensify. A large door stands at the end of the room. Decorated with gold and silver vines, the door to the throne room.\n" +
                   "You feel your journey is coming to an end.)";
            String room6 = "INSERT INTO MAP VALUES(6, Bursting through the door, you come to a stop in the middle of a marble floor. Pillars surround you, one in each corner of the room.\n" +
                   "A giant chandelier hangs in the centre, all the candles lit. Ahead of you is a throne. A red velvet chair trimmed in gold, wrapped in silver vines. \n" +
                   "Atop the chair sits a man. Towering above you, in purple robes, an ornate mask of iron adorns his face. The Evil Emperor Gnosis!\n" +
                   "He stands, robes billowing as  he takes a single step forward. The candles on the chandelier go out. The only source of light now being the moon.\n" +
                   "It illuminates his mask, and the green eyes staring from beneath it. He does not speak, but raises a hand. And with that, Gnosis lunges at you!)";
            
            st.addBatch(intro);
            st.addBatch(room1);
            st.addBatch(room2);
            st.addBatch(room3);
            st.addBatch(room4);
            st.addBatch(room5);
            st.addBatch(room6);
            
            st.executeBatch();
            
            st.close();
            conn.close();
            return true;

            }
                    return false;
    }
    
    //ifMapExists
    public boolean ifExists(Connection conn, String tableName) throws SQLException {
        
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getTables(null, null, tableName, new String[]{"TABLE"});
        
        return rs.next();
    }
}


