/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author jadey
 */
public class GUI extends JPanel {
    
    private final DrawPanel drawPanel;


    public GUI(){
       drawPanel = new DrawPanel();
       JPanel panel = new JPanel();
       panel.add(drawPanel);
       
       super.add(panel, BorderLayout.CENTER);
    }
    
     public class DrawPanel extends JPanel {
        public DrawPanel()
        {
            super.setPreferredSize(new Dimension(600,600));
            super.setBackground(Color.BLACK);
        }
}
}
