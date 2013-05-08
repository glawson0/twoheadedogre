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
    public Ogre ogre;
    public Face face;
    public Intro intro;
    public boolean hasStarted;
    /**
     * Constructor for objects of class GrassWorld.
     * 
     */
    private Random r;
    private LinkedList<Enemy> baddies;
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        r=new Random();
        face = new Face(true);
        ogre = new Ogre(new ImagePackage(), face);
        hasStarted = false;
        intro = new Intro();
	hasStarted = false;
        addObject(intro, 350, 300);
    }
    
    public void introPopulate() {
        addObject(face,50,50);
        addObject(ogre, 350, 300);
        populate();
    }
    public void populate(){
        baddies= makeEnemies(5);
        Enemy E;
        while( baddies.size()>0){
            E=baddies.pop();
            switch(r.nextInt(4)){
            case 0: addObject(E,0, r.nextInt(600));
                    break;
            case 1: addObject(E,700, r.nextInt(600));
                    break;
            case 2: addObject(E,r.nextInt(700),0);
                    break;
            case 3: addObject(E,r.nextInt(700),600);
                    break;
            }
        }
        
    }
    
    private LinkedList<Enemy> makeEnemies(int numE){
        LinkedList<Enemy> enemies= new LinkedList<Enemy>();
        for (int i=0; i< numE; i++){
            enemies.add(new Knight(new ImagePackage(), ogre));
        }
        return enemies;
    }

    public void act() {
    if (hasStarted){
        
    };
            
    }
}
