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
    
    /* Boolean to be set when actor is attacking. */
    private boolean isAttacking;
    
    /* Timers and indexes for imgPack. */
    private int attackTimer;
    private int currIdle;
    private int idleTimer;
    private int currUp;
    private int upTimer;
    private int currRight;
    private int rightTimer;
    private int currDown;
    private int downTimer;
    private int currLeft;
    private int leftTimer;
    
    /* Integer flags for timing animations. */
    int isIdle;
    int isMovingUp;
    int isMovingRight;
    int isMovingDown;
    int isMovingLeft;
    
    /**
     * Construct an animated actor.
     * 
     * @param imgPack The ImagePackage to be associated with the actor.
     */
    public AnimatedActor(ImagePackage imgPack)
    {
        super();
        this.imgPack = imgPack;
        isAttacking = false;
        attackTimer = 0;
        currIdle = 0;
        idleTimer = 0;
        currUp = 0;
        upTimer = 0;
        currRight = 0;
        rightTimer = 0;
        currDown = 0;
        downTimer = 0;
        currLeft = 0;
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
                resetIndexes("up");
                
                if (upTimer == 0) {
                    currUp = (currUp + 1) % imgPack.imgArrayLen("up");
                    setImage(imgPack.getImage("up",currUp));
                }
                upTimer = (upTimer + 1) % 60;
            }
            else if (Greenfoot.isKeyDown("right")) {
                resetTimers("right");
                resetIndexes("right");
                
                if (rightTimer == 0) {
                    currRight = (currRight + 1) % imgPack.imgArrayLen("right");
                    setImage(imgPack.getImage("right",currRight));
                }
                rightTimer = (rightTimer + 1) % 60;
            }
            else if (Greenfoot.isKeyDown("down")) {
                resetTimers("down");
                resetIndexes("down");
                
                if (downTimer == 0) {
                    currDown = (currDown + 1) % imgPack.imgArrayLen("down");
                    setImage(imgPack.getImage("down",currDown));
                }
                downTimer = (downTimer + 1) % 60;
            }
            else if (Greenfoot.isKeyDown("left")) {
                resetTimers("left");
                resetIndexes("left");
                
                if (leftTimer == 0) {
                    currLeft = (currLeft + 1) % imgPack.imgArrayLen("left");
                    setImage(imgPack.getImage("left",currLeft));
                }
                leftTimer = (leftTimer + 1) % 60;
            }
            else {
                resetTimers("idle");
                resetIndexes("idle");
                
                if (idleTimer == 0) {
                    currIdle = (currIdle + 1) % imgPack.imgArrayLen("idle");
                    setImage(imgPack.getImage("idle",currIdle));
                }
                idleTimer = (idleTimer + 1) % 60;
            }
        }
        else {
            resetTimers("idle");
            resetIndexes("idle");
            
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
    
    /**
     * Resets array indexes and timers for animation purposes.
     * Direction should be the direction being currently animated.
     * 
     * @param direction "up" "right" "down" "left"
     *                  => any other string will reset as idle.
     */
    public void resetIndexes(String direction) {
        if (direction.equals("up")) {
            currIdle = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
        }
        else if (direction.equals("right")) {
            currUp = 0;
            currIdle = 0;
            currDown = 0;
            currLeft = 0;
        }
        else if (direction.equals("down")) {
            currUp = 0;
            currRight = 0;
            currIdle = 0;
            currLeft = 0;
        }
        else if (direction.equals("left")) {
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currIdle = 0;
        }
        else { // idle image set case
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
        }
    }
}
