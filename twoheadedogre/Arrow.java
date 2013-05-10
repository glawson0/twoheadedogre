import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{    
    public void act() 
    {
        move(2);
        if(getX()<1 || getX()>690 || getY()<1 || getY()>590){
            getWorld().removeObject(this);
            return;
        }
        java.util.List <Ogre> objs= getIntersectingObjects(Ogre.class);
        for(Ogre o: objs){
            if(((GrassWorld)getWorld()).Invinc ==0){
             ((GrassWorld)getWorld()).Invinc=80;
             ((GrassWorld)getWorld()).HP--;
             getWorld().removeObject(this);
             return;
            }
            getWorld().removeObject(this);
        }
    }    
}
