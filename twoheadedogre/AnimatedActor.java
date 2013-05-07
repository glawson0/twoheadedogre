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
    private int idleTimer;
    private int upTimer;
    private int rightTimer;
    private int downTimer;
    private int leftTimer;
    
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
        idleTimer = 0;
        upTimer = 0;
        rightTimer = 0;
        downTimer = 0;
        leftTimer = 0;
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
                resetTimers("up");
                upTimer = (upTimer + 1) % 60;
                if (upTimer == 0)
                    setImage(imgPack.getImage("up"));
            }
            else if (Greenfoot.isKeyDown("right")) {
                resetTimers("right");
                rightTimer = (rightTimer + 1) % 60;
                if (rightTimer == 0)
                    setImage(imgPack.getImage("right"));
            }
            else if (Greenfoot.isKeyDown("down")) {
                resetTimers("down");
                downTimer = (downTimer + 1) % 60;
                if (downTimer == 0)
                    setImage(imgPack.getImage("down"));
            }
            else if (Greenfoot.isKeyDown("left")) {
                resetTimers("left");
                leftTimer = (leftTimer + 1) % 60;
                if (leftTimer == 0)
                    setImage(imgPack.getImage("left"));
            }
            else {
                resetTimers("idle");
                idleTimer = (idleTimer + 1) % 60;
                if (idleTimer == 0)
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
    
        /**
     * Resets array indexes and timers for animation purposes.
     * Direction should be the direction being currently animated.
     * 
     * @param direction "up" "right" "down" "left"
     *                  => any other string will reset as idle.
     */
    public void resetTimers(String direction) {
        if (direction.equals("up")) {
            idleTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("right")) {
            upTimer = 0;
            idleTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("down")) {
            upTimer = 0;
            rightTimer = 0;
            idleTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("left")) {
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            idleTimer = 0;
        }
        else { // idle image set case
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
    }
}
