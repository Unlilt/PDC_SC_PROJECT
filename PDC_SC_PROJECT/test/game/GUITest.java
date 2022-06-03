/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
public class GUITest {
    
    public GUITest() {
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
     * Test of main method, of class GUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of battleStart method, of class GUI.
     */
    @Test
    public void testBattleStart() {
        System.out.println("battleStart");
        GUI instance = new GUI();
        instance.battleStart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bossBattle method, of class GUI.
     */
    @Test
    public void testBossBattle() {
        System.out.println("bossBattle");
        GUI instance = new GUI();
        instance.bossBattle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finale method, of class GUI.
     */
    @Test
    public void testFinale() {
        System.out.println("finale");
        GUI instance = new GUI();
        instance.finale();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
