import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Face here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Face extends Actor
{
    public boolean face;
    private boolean pushed = false;
   public Face(boolean face){
       this.face = face;
       change();
   }
   public void act(){
        processKeys();
    }
   private void processKeys() {
       /* if(Greenfoot.isKeyDown("control") && !pushed) {
            face = !face;
            pushed = true;
            change();
        } 
        if(!Greenfoot.isKeyDown("control")){
            pushed = false;
        }*/
    }
   public void change(){
        if (face){
            //Use Dimond
            setImage("Gordo.png");
        }
        else{
            //Use Club
            setImage("Omak.png");
        }
    }
}
