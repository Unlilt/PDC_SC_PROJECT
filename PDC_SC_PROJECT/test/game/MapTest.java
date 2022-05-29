/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jadey
 */
public class MapTest {
    
    public MapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRoomDesc method, of class Map.
     */
    @Test
    public void testGetRoomDesc() {
        Map map = new Map();
        System.out.println("getRoomDesc");
        int key = 0;
        String expResult = "You are a brave hero who has been captured by the evil emperor Gnosis! "
                    + "Thrown into the dungeon of his castle to rot, you plot an escape.\n" +
                    "One day, a large explosion rock the castle, rubble falling into your chamber. The force has knocked loose the cage door from the stone!\n" +
                    "This is your chance!\n" +
                    "Onward brave hero!) ";
        String result = "";
        try {
            result = map.getRoomDesc(key);
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(MapTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of createMap method, of class Map.
     */
    @Test
    public void testCreateMap() throws Exception {
        System.out.println("createMap");
        Map instance = new Map();
        instance.createMap();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of ifExists method, of class Map.
     */
    @Test
    public void testIfExists() throws Exception {
        System.out.println("ifExists");
        DBManager db = new DBManager();
        Connection conn = db.getConnection();
        String tableName = "MAP";
        Map instance = new Map();
        boolean expResult = false;
        boolean result = instance.ifExists(conn, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
