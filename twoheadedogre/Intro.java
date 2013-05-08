import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends Actor
{

    public Intro(){
        getImage().scale(500, 400);
    }

    /**
     * Act - do whatever the Intro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        if( Greenfoot.isKeyDown("up") ||
            Greenfoot.isKeyDown("down") ||
            Greenfoot.isKeyDown("left") ||
            Greenfoot.isKeyDown("right") ||
            Greenfoot.isKeyDown("a") ||
            Greenfoot.isKeyDown("s") ||
            Greenfoot.mouseClicked(this)
        )
        {
            ((GrassWorld)getWorld()).hasStarted = true;
	    ((GrassWorld)getWorld()).introPopulate();
            getWorld().removeObject(this);
        }
    }    
}
