import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SoundActor
{
    private int aliveTimer;
    
    public Enemy(ImagePackage imgPack) {
       super(imgPack);
       aliveTimer = 0;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        aliveTimer++;
        if (aliveTimer > 150) {
           ((GrassWorld)getWorld()).voicePack.playDialog("knight",false);
           aliveTimer = 0;
        }
    }
    protected void checkCollision(){
        java.util.List <Actor> objs= getIntersectingObjects(Actor.class);
        if (((GrassWorld)getWorld()).Invinc>0){
            ((GrassWorld)getWorld()).Invinc--;
        }
        
        for(Actor obj: objs){
            if (obj instanceof Ogre){
                isAttacking = true;
                Ogre O= (Ogre)obj;
                boolean facingOK = false;
                switch (O.currDirection){
                    case NORTH: facingOK =(getY()<O.getY()) ? true: false;
                                break;
                    case SOUTH: facingOK= (getY()>O.getY()) ? true : false;
                                break;
                    case EAST: facingOK=(getX()>O.getX()) ? true : false;
                                break;
                    case WEST: facingOK= (getY()<O.getY()) ? true : false;
                                break;
                }
                if ( O.isAttacking && (facingOK || (O.getX()==getX() ||O.getY()==getY()))){
                    ((GrassWorld)getWorld()).BaddieCount--;
                    getWorld().removeObject(this);
                    return;
                }else{
                    int xd= Math.abs(getX()-O.getX());
                    int yd= Math.abs(getY()-O.getY());
                    int x=0;
                    int y=0;
                    if(xd>yd){
                        if( getX()< obj.getX()){
                            x-=5;
                        }else if( getX()> obj.getX()){
                            x+=5;
                        }
                    }else{
                        if( getY()< obj.getY()){
                            y-=5;
                        }else if( getY()> obj.getY()){
                            y+=5;
                        }
                    }
                    setLocation(getX()+x, getY()+y);
                    if((this instanceof Knight) && this.isAttacking &&((GrassWorld)getWorld()).Invinc ==0){
                        ((GrassWorld)getWorld()).Invinc=60;
                        ((GrassWorld)getWorld()).HP--;
                    }
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
