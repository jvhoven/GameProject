package rpg;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable {
    
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    
    private Thread thread;
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    private int FPS = 30;
    private int targetTime = 1000 / FPS;
    
    public Gamepanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
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
        
        long startTime;
        long urdTime;
        long waitTime;
        
        while(running){
            startTime = System.nanoTime();
            
            update();
            render();
            draw();
            
            urdTime = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - urdTime;
            
            try{
                Thread.sleep(waitTime);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private void init(){
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
    }
    
    /////////////////////////////////////////////////////////////////////////
    
    private void update(){}
    private void render(){}
    private void draw(){}
    
}
