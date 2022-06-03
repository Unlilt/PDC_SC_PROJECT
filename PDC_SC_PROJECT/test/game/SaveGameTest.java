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
public class SaveGameTest {
    
    public SaveGameTest() {
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
     * Test of saveGame method, of class SaveGame.
     */
    @Test
    public void testSaveGame() throws Exception {
        System.out.println("saveGame");
        Player pc = new Player("Maria");
        pc.roomCount = 4;
        SaveGame.saveGame(pc);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
