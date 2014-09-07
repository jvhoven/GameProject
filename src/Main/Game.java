package Main;

import javax.swing.JFrame;

public class Game {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Gameprojet");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Gamepanel());
        window.pack();
        window.setVisible(true); 
    }
}
