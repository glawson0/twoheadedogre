import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class GrassWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassWorld extends World
{
    public Ogre ogre;
    public Face face;
    public Intro intro;
    public boolean hasStarted;
    /**
     * Constructor for objects of class GrassWorld.
     * 
     */
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        face = new Face(true);
        ogre = new Ogre(new ImagePackage(), face);
        intro = new Intro(new ScoreBoard());
	hasStarted = false;
        addObject(intro, 350, 300);
    }
    
    public void introPopulate() {
        addObject(face,50,50);
        addObject(ogre, 350, 300);
    }

    public void populate() {
        addObject(new Knight(new ImagePackage(), ogre), 500,600);
    }

    public void act() {
	if (hasStarted)
            populate();
    }
}
