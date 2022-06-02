/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;



import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jadey
 */
public class GUI extends JPanel {
    
//    private final DrawPanel drawPanel;
    JFrame window;
    private CardLayout cLayout;
    private  JButton loadGameBtn;
    private  JButton newGameBtn;
    private  JLabel titleLabel;
    private  JPanel titlePanel;
    private  JPanel panelCont = new JPanel();
    
    public GUI(){
         try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        setLayout(null);
        cLayout = new CardLayout();
        initComponents();
       
        
//        
//        titlePanel.add(newGameBtn);
//        titlePanel.add(loadGameBtn);
//        titlePanel.add(titleLabel);
//        titlePanel.setVisible(true);
//        
//        super.add(titlePanel);
        
        
        
    }
    
//     public class DrawPanel extends JPanel {
//        public DrawPanel()
//        {
//            super.setPreferredSize(new Dimension(800,600));
//            super.setBackground(Color.BLACK);
//        }
    
    //Main method for testing
    public static void main(String[] args) {
          GUI gameGui = new GUI();
            //Create/initialize GUI
            JFrame window = new JFrame("Evil Emperor Oz Rising!");
            window.setPreferredSize(new Dimension(800, 600));
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setContentPane(gameGui);
            window.pack();
            window.setVisible(true);
    }

    private void initComponents() {
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 800, 600);
        newGameBtn = new JButton();
        loadGameBtn = new JButton();
        titleLabel = new JLabel();

        panelCont.setLayout(cLayout);
        
        newGameBtn.setText("New Game");
        newGameBtn.setLocation(100, 700);
        newGameBtn.setVisible(true);

        loadGameBtn.setText("Load Game");
        loadGameBtn.setVisible(true);
        
        
        titleLabel.setAlignmentX(TOP_ALIGNMENT);
        titleLabel.setAlignmentY(TOP_ALIGNMENT);
        titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        titleLabel.setText("OZIRIS RISING");
        titleLabel.setVisible(true);
        
//        
        titlePanel.add(newGameBtn);
        titlePanel.add(loadGameBtn);
        titlePanel.add(titleLabel);
        titlePanel.setVisible(true);
        
        panelCont.add(titlePanel, "1");
//        cLayout.show(panelCont, "1");
        
        super.add(titlePanel);    
    }
}

