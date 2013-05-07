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
    public Knight(ImagePackage imgPack, Ogre ogre){
        super(imgPack);
        this.ogre=ogre;
    }
    public void act() 
    {
        move();
        checkCollision();
    }
    private void move(){
        int x=0;
        int y=0;
        if (ogre.getX()< getX() ){
            x-=3;
        }else if (ogre.getX()> getX() ){
            x+=3;
        }
        if (ogre.getY()< getY() ){
            y-=3;
        }else if (ogre.getY()> getY() ){
            y+=3;
        }
        setLocation(getX()+x,getY()+y);
    }
}
