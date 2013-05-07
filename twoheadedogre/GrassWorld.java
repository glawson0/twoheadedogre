import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.util.Random;
/**
 * Write a description of class GrassWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassWorld extends World
{

    /**
     * Constructor for objects of class GrassWorld.
     * 
     */
    protected Ogre ogre;
    protected LinkedList<Enemy> enemies;
    private int ENEMIES = 3;
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        populate();
        
    }
    private void populate(){
        ogre=new Ogre();
        enemies= new LinkedList<Enemy>();
        Random r = new Random();
        int x,y;
        for (int i=0; i<ENEMIES; i++){
            Enemy curr =new Knight(ogre);
            //enemies.add(curr);
            switch (r.nextInt(4)){
                case 0: addObject(curr,0,r.nextInt(600));
                    break;
                case 1: addObject(curr,700,r.nextInt(600));
                    break;
                case 2: addObject(curr,r.nextInt(700),600);
                    break;
                case 3: addObject(curr,r.nextInt(700),0);
                    break;
            }
        }
        addObject(ogre,300,300);
    }
}
