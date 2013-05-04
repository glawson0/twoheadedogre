import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ogre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ogre extends Actor
{
    /**
     * Act - do whatever the Ogre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean walking= true;
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private int switchWait =0;
    public void act() 
    {
        if(switchWait<1){
            switchHead();
            switchWait=6;
        }else{
            switchWait--;
        }
        procInput();
    }    
    private void switchHead(){
        if (Greenfoot.isKeyDown("s")){
            walking= !walking;
        }
    }
    private void procInput(){
        int x =0;
        int y=0;
        int dir=-1;
        if(Greenfoot.isKeyDown("left")){
            if (walking){
                x-=5;
            }else{
                dir=WEST;
            }
        }
        if(Greenfoot.isKeyDown("right")){
            if (walking){
                x+=5;
            }else{
                dir=EAST;
            }
        }
        if(Greenfoot.isKeyDown("up")){
            if (walking){
                y-=5;
            }else{
                dir=NORTH;
            }
        }
        if(Greenfoot.isKeyDown("down")){
            if (walking){
                y+=5;
            }else{
                dir=SOUTH;
            }
        }
        setLocation(getX()+x,getY()+y);
        switch(dir){
            case 0: setRotation(0);
                    break;
            case 1: setRotation(270);
                    break;
            case 2: setRotation(180);
                    break;
            case 3: setRotation(90);
                    break;
        }
        
    }
}
