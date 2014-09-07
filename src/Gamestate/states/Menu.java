package Gamestate.states;

import Gamestate.Gamestate;
import Gamestate.Manager;
import Map.Background;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends Gamestate{
    
    private Background bg;
    
    private int currentChoice = 0;
    private static final String TITLE = "Wesley is gay";
        
    private String[] options = {
        "Start",
        "Help",
        "Quit"
    };
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;
    
    public Menu(Manager gsm) {
        
        this.gsm = gsm;
        
        try{
           // bg = new Background("/Background/menubg.gif", 1);
            //bg.setVector(-0.1, 0);
            
            titleColor = new Color(128, 0, 0);
            titleFont = new Font("Verdana", Font.PLAIN, 28);
            
            font = new Font("Arial", Font.PLAIN, 12);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void init() {
    }

    public void update() {
        //bg.update();
    }

    public void draw(Graphics2D g) {
        // Draw background
        //bg.draw(g);
        
        // Draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString(TITLE, 80, 70);
        
        // Draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }
    }

    private void select(){
        switch(currentChoice){
            case 0:
                // Start game
                break;
            
            case 1:
                // Help
                break;
                
            case 2:
                System.exit(0);
                break;
        }
    }
    
    public void keyPressed(int k) {
                
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == -1){
                currentChoice = 0;
            }
        }
        
    }

    public void keyReleased(int k) {
    }
    
}
