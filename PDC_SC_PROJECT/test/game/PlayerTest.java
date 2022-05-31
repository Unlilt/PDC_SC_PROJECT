/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.SQLException;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of death method, of class Player.
     */
    @Test
    public void testDeath() throws SQLException { 
        System.out.println("death");
        String killer = "Camel";
        Player.death(killer);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of win method, of class Player.
     */
    @Test
    public void testWin() throws SQLException {
        System.out.println("win");
        Player pc = new Player("Jade");
        int xp = 120;
        Player.win(pc, xp);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rest method, of class Player.
     */
    @Test
    public void testRest() throws SQLException {
        System.out.println("rest");
        Player instance = new Player("Jade");
        instance.rest();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ifPlayerExists method, of class Player.
     */
    @Test 
    public void testIfPlayerExists() throws Exception {
        System.out.println("ifPlayerExists");
        String name = "Jade";
        boolean expResult = true;
        boolean result = Player.ifPlayerExists(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
       @Test 
    public void testIfPlayerExistsShouldReturnFalse() throws Exception {
        System.out.println("ifPlayerExists");
        String name = "Nekira";
        boolean expResult = false;
        boolean result = Player.ifPlayerExists(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    
}
}
