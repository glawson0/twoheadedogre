import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SoundActor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    public Enemy(ImagePackage imgPack) {
       super(imgPack);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        checkCollision();
    }
    protected void checkCollision(){
        java.util.List <Actor> objs= getIntersectingObjects(Actor.class);
        for(Actor obj: objs){
            if (obj instanceof Ogre){
                Ogre O= (Ogre)obj;
                boolean facingOK = false;
                switch (O.facing){
                    case NORTH: facingOK =(getY()<O.getY()) ? true: false;
                                break;
                    case SOUTH: facingOK= (getY()>O.getY()) ? true : false;
                                break;
                    case EAST: facingOK=(getX()>O.getX()) ? true : false;
                                break;
                    case WEST: facingOK= (getY()<O.getY()) ? true : false;
                                break;
                }
                if (O.isAttacking && facingOK){
                    getWorld().removeObject(this);
                    return;
                }else{
                    
                }
            }else if(obj instanceof Enemy){
                int x=0;
                int y=0;
                if( getX()< obj.getX()){
                    x-=3;
                }else if( getX()> obj.getX()){
                    x+=3;
                }
                if( getY()< obj.getY()){
                    y-=3;
                }else if( getY()> obj.getY()){
                    y+=3;
                }
                setLocation(getX()+x, getY()+y);
            }
        }
    }
}
