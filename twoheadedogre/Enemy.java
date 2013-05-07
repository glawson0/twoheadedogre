import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SoundActor
{
    public Enemy(ImagePackage imgPack) {
       super(imgPack);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollision();
    }
    protected void checkCollision(){
        java.util.List <Actor> objs= getIntersectingObjects(Actor.class);
        for(Actor obj: objs){
            if (obj instanceof Ogre){
                getWorld().removeObject(this);
            }else{
                int x=0;
                int y=0;
                if( getX()< obj.getX()){
                    x-=5;
                }else if( getX()> obj.getX()){
                    x+=5;
                }
                if( getY()< obj.getY()){
                    y-=5;
                }else if( getY()> obj.getY()){
                    y+=5;
                }
                setLocation(getX()+x, getY()+y);
            }
        }
    }
}
