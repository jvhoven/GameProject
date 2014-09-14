package Gamestate.states;

import Entity.Player;
import Gamestate.*;
import Main.Gamepanel;
import Map.Background;
import Map.Tile;
import Map.TileMap;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1 extends Gamestate {
    
    private TileMap tileMap;
    private Background bg;
    
    private Player player;
    
    public Level1(Manager gsm){
        this.gsm = gsm;
        init();
    }
    
    public void init(){
    
        tileMap = new TileMap(30);
        tileMap.loadTiles("grasstileset.gif");
        tileMap.loadMap("Level1-1.map");
        tileMap.setPosition(0, 0);
        tileMap.setTween(1);
        
        bg = new Background("grassbg1.gif", 0.1);
        
        player = new Player(tileMap);
        player.setPosition(100, 100);
    }
    
    public void update(){
        
        // update player
        player.update();
        tileMap.setPosition(Gamepanel.WIDTH / 2 - player.getx(), Gamepanel.HEIGHT / 2 - player.gety());
    
    }
    public void draw(Graphics2D g){
    
        // draw bg
        bg.draw(g);
        
        // draw tilemap
        tileMap.draw(g);
        
        // draw player
        player.draw(g);
        
    }
    public void keyPressed(int k){
        
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
        if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_UP) player.setUp(true);
        if(k == KeyEvent.VK_DOWN) player.setDown(true);
        if(k == KeyEvent.VK_SPACE) player.setJumping(true);
        if(k == KeyEvent.VK_E) player.setGliding(true);
        if(k == KeyEvent.VK_R) player.setScratching();
        if(k == KeyEvent.VK_F) player.setFiring();
    
    }
    public void keyReleased(int k){
        
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
        if(k == KeyEvent.VK_RIGHT) player.setRight(false);
        if(k == KeyEvent.VK_UP) player.setUp(false);
        if(k == KeyEvent.VK_DOWN) player.setDown(false);
        if(k == KeyEvent.VK_SPACE) player.setJumping(false);
        if(k == KeyEvent.VK_E) player.setGliding(false);
        if(k == KeyEvent.VK_R) player.setScratching();
        if(k == KeyEvent.VK_F) player.setFiring();
    }
    
}
