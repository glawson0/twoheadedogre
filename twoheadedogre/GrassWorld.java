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
    public Ogre ogre;
    public Face face;
    private Random r;
    private LinkedList<Enemy> baddies;
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        r=new Random();
        face = new Face(true);
        ogre = new Ogre(new ImagePackage(), face);
        populate();
    }
    
    public void populate() {
        addObject(face,50,50);
        addObject(ogre, 350, 300);
        baddies= makeEnemies(5);
        
        for(Enemy E: baddies){
            switch(r.getInt(4)){
                case 0: addObject(E,0
                
            }
        }
        
    }
    
    private LinkedList<Enemy> makeEnemies(int numE){
        LinkedList<Enemy> enemies= new LinkedList<Enemy>();
        for (int i=0; i< numE; i++){
            enemies.add(new Knight(new ImagePackage(), ogre));
        }
        return enemies
    }
}
