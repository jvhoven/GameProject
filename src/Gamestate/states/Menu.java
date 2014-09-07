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
    
    private String fontFamily = "Eras Light ITC";
    
    private Color titleColor;
    private Font titleFont;
    
    private Color fontColor;
    private Color fontColorActive;
    private Font font;
    
    private int correction = 8;
    
    public Menu(Manager gsm) {
        
        this.gsm = gsm;
        
        try{
            bg = new Background("menubg.gif", 1);
            bg.setVector(-0.1, 0);
            
            titleColor = new Color(255, 255, 255);
            titleFont = new Font(fontFamily, Font.PLAIN, 36);
            
            fontColor = new Color(150, 150, 150);
            fontColorActive = new Color(255, 255, 255);
            font = new Font(fontFamily, Font.PLAIN, 28);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void init() {
    }

    public void update() {
        bg.update();
    }

    public void draw(Graphics2D g) {
        // Draw background
        bg.draw(g);
        
        // Draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        
        int titlegLength = (int) g.getFontMetrics().getStringBounds(TITLE, g).getWidth();
        int titleStart = Main.Gamepanel.WIDTH/4 - titlegLength/2 - correction;
        
        g.drawString(TITLE, titleStart, 50);
        
        // Draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(fontColorActive);
            } else {
                g.setColor(fontColor);
            }
            
            int stringLen = (int) g.getFontMetrics().getStringBounds(options[i], g).getWidth();  
            int start = Main.Gamepanel.WIDTH/4 - stringLen/2 - correction;  
            
            g.drawString(options[i], start, 125 + i * 30);
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
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
        
    }

    public void keyReleased(int k) {
    }
    
}
