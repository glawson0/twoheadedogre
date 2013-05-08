import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends Actor
{
    private boolean started = false;
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    public Intro(){
        getImage().scale(500, 400);
        makeText("Starter");
    }

    /**
     * Act - do whatever the Intro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        if( (Greenfoot.isKeyDown("up") ||
            Greenfoot.isKeyDown("down") ||
            Greenfoot.isKeyDown("left") ||
            Greenfoot.isKeyDown("right") ||
            Greenfoot.isKeyDown("a") ||
            Greenfoot.isKeyDown("s") ||
            Greenfoot.mouseClicked(this)) &&
            !started
        )
        {
            ((GrassWorld)getWorld()).hasStarted = true;
	    ((GrassWorld)getWorld()).introPopulate();
            getWorld().removeObject(this);
            started = true;
        }
    }    
    /**public void addObject(ScoreBoard sb){
        getWorld().addObject(this.sb, 350, 300);
    }*/
    
    public void makeText(String str){
        GreenfootImage image = getImage();

        //image.setColor(new Color(0, 0, 0, 160));
        //image.fillRect(0, 0, WIDTH, HEIGHT);
        //image.setColor(new Color(255, 255, 255, 100));
        //image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.BLACK);
        //image.drawString(title, 60, 100);
        image.drawString(str, 60, 50);
        setImage(image);
    }
}
