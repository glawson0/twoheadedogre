import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    private ImagePackage imgPack;
    private boolean isAttacking;
    private int attackTimer;
    
    /**
     * Construct an animated actor. This assumes that you have provided image
     * file (in the 'images' folder) named 'basenameN.suffix', where N is
     * [0..numberOfImages-1].
     * 
     * @param basename  The base name of the image files.
     * @param suffix  The suffix of the image files (must include the ".").
     * @param noOfImages  The number of images to be use din the animation.
     */
    public AnimatedActor(ImagePackage imgPack)
    {
        this.imgPack = imgPack;
        isAttacking = false;
        attackTimer = 0;
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage();
    }
    
    public void setImage() {
        if (!isAttacking) {
            if (Greenfoot.isKeyDown("up")) {
               setImage(imgPack.getImage("up"));
            }
            else if (Greenfoot.isKeyDown("right")) {
               setImage(imgPack.getImage("right"));
            }
            else if (Greenfoot.isKeyDown("down")) {
               setImage(imgPack.getImage("down"));
            }
            else if (Greenfoot.isKeyDown("left")) {
               setImage(imgPack.getImage("left"));
            }
            else {
               setImage(imgPack.getImage("idle"));
            }
        }
        else {
            attackTimer = (attackTimer + 1) % 60;
            
            if (attackTimer == 0) {
                isAttacking = false;
                setImage();
                return;
            }
            
            if (Greenfoot.isKeyDown("up")) {
               setImage(imgPack.getUpAttack());
            }
            else if (Greenfoot.isKeyDown("right")) {
               setImage(imgPack.getRightAttack());
            }
            else if (Greenfoot.isKeyDown("down")) {
               setImage(imgPack.getDownAttack());
            }
            else if (Greenfoot.isKeyDown("left")) {
               setImage(imgPack.getLeftAttack());
            }
        }
    }
}
