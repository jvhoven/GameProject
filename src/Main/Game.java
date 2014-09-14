package Main;

import javax.swing.JFrame;
import Main.Gamepanel;

public class Game {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Gameproject");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Gamepanel());
        window.pack();
        window.setSize(Gamepanel.WIDTH, Gamepanel.HEIGHT);
        window.setVisible(true); 
        window.setResizable(false);
    }
}
