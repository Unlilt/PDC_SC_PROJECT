/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.SQLException;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Game {
    //Initializing
    
    public Game() throws SQLException{
        Map.loadMap();
        GameLogic gl = new GameLogic();
        Thread thread = new Thread(gl);
        thread.start();
    }

  

 
}
