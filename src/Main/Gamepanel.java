package Main;

import Gamestate.Manager;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable, KeyListener {
    
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int SCALE = 2;
    
    private Thread thread;
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    private int FPS = 60;
    private int targetTime = 1000 / FPS;
    
    /*
    * Gamestate manager
    *
    * @see Gamestate_Manager.java
    */
    private Manager gsm;
    
    public Gamepanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        requestFocus();
    }
    
    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public void run() {
        init();
        
        long start;
        long elapsed;
        long wait;
        
        while(running){
            start = System.nanoTime();
            
            update();
            render();
            draw();
            
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            
            if(wait < 0) wait = 5;
            
            try{
                Thread.sleep(wait);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private void init(){
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        
        gsm = new Manager();
    }
    
    /////////////////////////////////////////////////////////////////////////
    
    private void update(){
        gsm.update();
    }
    
    private void render(){
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        g2.dispose();
    }
    
    private void draw(){
        gsm.draw(g);
    }
    
  
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }
}
