/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 * @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Main extends JFrame{

    /**Jade
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
            GUI gameGui = new GUI();
            //Create/initialize GUI
            JFrame f = new JFrame("Evil Emperor Oz Rising!");
            f.setPreferredSize(new Dimension(500, 500));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setContentPane(gameGui);
            f.pack();
            f.setVisible(true);
            
            GameLogic gl = new GameLogic();
            gl.Start();
    }
    
}
