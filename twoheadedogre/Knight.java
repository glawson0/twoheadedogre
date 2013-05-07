import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Enemy
{
    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Ogre ogre;
    public Knight(Ogre ogre){
        super();
        this.ogre=ogre;
    }
    public void act() 
    {
        super.act();
        move();
    }
    private void move(){
        int x=0;
        int y=0;
        if (ogre.getX()< getX() ){
            x-=2;
        }else if (ogre.getX()> getX() ){
            x+=2;
        }
        if (ogre.getY()< getY() ){
            y-=2;
        }else if (ogre.getY()> getY() ){
            y+=2;
        }
        setLocation(getX()+x,getY()+y);
    }
}
