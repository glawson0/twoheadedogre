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
    
    public ImagePackage ogrePack;
    public ImagePackage knightPack;
    public ImagePackage archerPack;
    
    private Random r;
    private LinkedList<Enemy> baddies;
    public int BaddieCount=0;

    /**
     * Constructor for objects of class GrassWorld.
     */
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        r=new Random();
        face = new Face(true);
        
        ogrePack = new ImagePackage();
        ogrePack.SetupUpImages("OgreUp",".png",2);
        ogrePack.SetupDownImages("OgreDown",".png",2);
        ogrePack.SetupLeftImages("OgreLeft",".png",2);
        ogrePack.SetupRightImages("OgreRight",".png",2);
        ogrePack.SetupAttackImage("OgreUpAttack.png","up");
        ogrePack.SetupAttackImage("OgreDownAttack.png","down");
        ogrePack.SetupAttackImage("OgreLeftAttack.png","left");
        ogrePack.SetupAttackImage("OgreRightAttack.png","right");
        
        knightPack= new ImagePackage();
        knightPack.SetupUpImages("knightup",".png",3);
        knightPack.SetupDownImages("knightdown",".png",3);
        knightPack.SetupLeftImages("knightleft",".png",2);
        knightPack.SetupRightImages("knightright",".png",2);
        knightPack.SetupAttackImage("knightup4.png","up");
        knightPack.SetupAttackImage("knightdown4.png","down");
        knightPack.SetupAttackImage("knightleft3.png","left");
        knightPack.SetupAttackImage("knightright3.png","right");
        
        archerPack= new ImagePackage();
        archerPack.SetupUpImages("archerup",".png",3);
        archerPack.SetupDownImages("archerdown",".png",3);
        archerPack.SetupLeftImages("archerleft",".png",2);
        archerPack.SetupRightImages("archerright",".png",2);
        
        ogre = new Ogre(ogrePack, face);
        
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
        baddies= makeEnemies(10);
        Enemy E;
        while( baddies.size()>7){
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
            BaddieCount++;
        }
        
    }
    
    private LinkedList<Enemy> makeEnemies(int numE){
        LinkedList<Enemy> enemies= new LinkedList<Enemy>();
        enemies.add( new Archer(archerPack, ogre));
        for (int i=0; i< numE; i++){
            enemies.add(new Knight(knightPack, ogre));
        }
        return enemies;
    }

    public void act() {
        if (hasStarted){
            Enemy E;
            while ((BaddieCount <2) && (baddies.size()> 0)){
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
                BaddieCount++;
            }
        }    
    }
}
