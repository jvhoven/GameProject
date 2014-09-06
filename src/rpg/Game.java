package rpg;

import javax.swing.JFrame;

public class Game {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Test project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Gamepanel());
        window.pack();
        window.setVisible(true); 
    }
    
    
    
}
