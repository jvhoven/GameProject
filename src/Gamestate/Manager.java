package Gamestate;

import java.util.ArrayList;
import Gamestate.states.*;

public class Manager {
    
    private ArrayList<Gamestate> gameStates;
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int LEVEL1STATE = 1;
    
    public Manager() {
        
        gameStates = new ArrayList<Gamestate>();
        gameStates.add(new Menu(this));
        
        currentState = 0;
        
    }
    
    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }
    
    public void update(){
        gameStates.get(currentState).update();
    }
    
    public void draw(java.awt.Graphics2D g){
        gameStates.get(currentState).draw(g);
    }
    
    public void keyPressed(int k){
        System.out.println(k);
        gameStates.get(currentState).keyPressed(k);
    }
    
    public void keyReleased(int k){
        gameStates.get(currentState).keyReleased(k);
    }
}
