import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP extends Actor
{
    /**
     * Act - do whatever the HP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static final float FONT_SIZE = 30.0f;
    private int WIDTH=120;
    private int HEIGHT=80;
    
    public HP(){
        
        setImage(new GreenfootImage(WIDTH, HEIGHT));
        
    }
    
    public void act() 
    {
        updateImage();
    }
    private void updateImage()  
    {  
        GreenfootImage image = getImage();  
        image.clear();  
        image.drawString("HP: " + ((GrassWorld)getWorld()).HP , 1, 30);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE); 
        image.setFont(font);
    } 
    /*
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }*/
}
