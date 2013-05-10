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
    
    public IntroImage introImg;
    public boolean hasStarted1;
    public boolean hasStarted2;
    public boolean hasStarted3;
    public GreenfootSound dialogPlaying;
    
    public ImagePackage ogrePack;
    public ImagePackage knightPack;
    public ImagePackage archerPack;
    
    private Random r;
    private LinkedList<LinkedList<Enemy>> levels;
    private LinkedList<Enemy> baddies;
    public int BaddieCount=0;
    private int roundwait=0;
    private int cLevel=1;
    public DialogPackage voicePack;
    
    public int HP=20;
    public int Invinc=0;
    private boolean gameOver= false;

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
        archerPack.SetupAttackImage("archerup1.png","up");
        archerPack.SetupAttackImage("archerdown1.png","down");
        archerPack.SetupAttackImage("archerleft1.png","left");
        archerPack.SetupAttackImage("archerright1.png","right");
        
        ogre = new Ogre(ogrePack, face);
        
        introImg = new IntroImage();
        addObject(introImg,350,300);
        
        hasStarted1 = false;
        hasStarted2 = false;
        hasStarted3 = false;
        
        voicePack = new DialogPackage(r);
    }
    
    public void introPopulate() {
        addObject(new HP(), 600,60);
        addObject(face,50,50);
        addObject(ogre, 350, 300);
        makeLevels();
    }
    
    public void populate(){
        makeLevels();
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
    
    private void makeLevels(){
        int levelcount=5;
        int baseEnemies=6;
        levels=new LinkedList<LinkedList<Enemy>>();
        
        for (int i=1; i<=5; i++){
            levels.addLast(makeEnemies(6*i));
        }
    }
    
    private LinkedList<Enemy> makeEnemies(int numE){
        LinkedList<Enemy> enemies= new LinkedList<Enemy>();
        
        for (int i=0; i< numE; i++){
            enemies.add(new Knight(knightPack, ogre));
            if(i%5==0)
                enemies.add( new Archer(archerPack, ogre));
        }
        return enemies;
    }

    public void act() {
        if (HP<1){
            gameOver=true;
        }
        
        if (gameOver){
            java.util.List <Actor> objs= getObjects(Actor.class);
            for(Actor thisAct: objs)
                removeObject(thisAct);
                
            if (HP<1){
                //bad end
                introImg = new IntroImage(6);
            }else{
                //good End
                introImg = new IntroImage(7);
            }
            hasStarted3 = false;
            addObject(introImg,350,300);
            Greenfoot.stop();
        }
        
        if (!hasStarted1) {
            keyPress(1);
        }
        else if (!hasStarted2) {
            keyPress(2);
            hasStarted3 = true;
        }
        else if (!hasStarted3) {
            keyPress(3);
        }
        else if (hasStarted1 && hasStarted2 && hasStarted3){
            voicePack.dialogAct();
            
            if (roundwait==0){
                if( levels.size()==0){
                    gameOver=true;
                    return;
                }
                Enemy E;
                while ((BaddieCount <(2*cLevel)) && (levels.get(0).size()> 0)){
                    E=levels.get(0).pop();
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
                    if (E instanceof Knight)
                      voicePack.playDialog("knight",face.face);
                    if (E instanceof Archer)
                      voicePack.playDialog("archer",face.face);
                    BaddieCount++;
                }
                if(BaddieCount==0 && (levels.get(0).size()== 0)){
                    hasStarted3 = false;
                    introImg = new IntroImage(cLevel);
                    addObject(introImg,350,300);
                    
                    java.util.List <Actor> objs = getObjects(Arrow.class);
                    if (objs.size() > 0)
                        removeObjects(objs);
                    
                    // this is here for is we want to narrate story boxes with voice
                    // dialogPlaying = new GreenfootSound("storyDialogX.wav");
                    // dialogPlaying.play();
                    
                    levels.remove();
                    roundwait=30;
                    cLevel+=1;
                }
            }else{
                roundwait--;
            }
        }    
    }

    /* Which press tracks how many times they've click or pressed a key. */
    public void keyPress(int whichPress) 
    {
        if(Greenfoot.mouseClicked(introImg))
        {
            if (whichPress == 1) {
                hasStarted1 = true;
                introImg.switchImg();
            }
            if (whichPress == 2) {
                hasStarted2 = true;
                removeObject(introImg);
                introPopulate();
            }
            if (whichPress == 3) {
                hasStarted3 = true;
                removeObject(introImg);
                // dialogPlaying.stop();
            }
        }
    }
}
