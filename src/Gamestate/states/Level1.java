package Gamestate.states;

import Gamestate.*;
import Main.Gamepanel;
import Map.Background;
import Map.Tile;
import Map.TileMap;
import java.awt.*;

public class Level1 extends Gamestate {
    
    private TileMap tileMap;
    private Background bg;
    
    public Level1(Manager gsm){
        this.gsm = gsm;
        init();
    }
    
    public void init(){
    
        tileMap = new TileMap(30);
        tileMap.loadTiles("grasstileset.gif");
        tileMap.loadMap("Level1-1.map");
        tileMap.setPosition(0, 0);
        
        bg = new Background("grassbg1.gif", 0.1);
    }
    public void update(){}
    public void draw(Graphics2D g){
    
        // draw bg
        bg.draw(g);
        
        // draw tilemap
        tileMap.draw(g);
        
    }
    public void keyPressed(int k){}
    public void keyReleased(int k){}
    
}
