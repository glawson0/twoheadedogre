import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass pertaining to animating actors.
 * 
 * @author Robin Verweij 
 * @version final!!?
 */
public class AnimatedActor extends Actor
{
    private ImagePackage imgPack;
    
    protected static final int animTime = 20;
    protected static final int EAST = 0;
    protected static final int WEST = 1;
    protected static final int NORTH = 2;
    protected static final int SOUTH = 3;
    protected int currDirection;
    
    /* Boolean to be set when actor is attacking. */
    protected boolean isAttacking;
    
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
       setMyImage();
    }
    
    
    public void setMyImage() {
        if (!isAttacking) {
            if (currDirection == NORTH) {
                resetTimers(currDirection);
                resetIndexes(currDirection);
                
                if (upTimer == 0) {
                    currUp = (currUp + 1) % imgPack.imgArrayLen("up");
                    setImage(imgPack.getImage("up",currUp));
                }
                upTimer = (upTimer + 1) % animTime;
            }
            else if (currDirection == EAST) {
                resetTimers(currDirection);
                resetIndexes(currDirection);
                
                if (rightTimer == 0) {
                    currRight = (currRight + 1) % imgPack.imgArrayLen("right");
                    setImage(imgPack.getImage("right",currRight));
                }
                rightTimer = (rightTimer + 1) % animTime;
            }
            else if (currDirection == SOUTH) {
                resetTimers(currDirection);
                resetIndexes(currDirection);
                
                if (downTimer == 0) {
                    currDown = (currDown + 1) % imgPack.imgArrayLen("down");
                    setImage(imgPack.getImage("down",currDown));
                }
                downTimer = (downTimer + 1) % animTime;
            }
            else if (currDirection == WEST) {
                resetTimers(currDirection);
                resetIndexes(currDirection);
                
                if (leftTimer == 0) {
                    currLeft = (currLeft + 1) % imgPack.imgArrayLen("left");
                    setImage(imgPack.getImage("left",currLeft));
                }
                leftTimer = (leftTimer + 1) % animTime;
            }
        }
        else {
            resetTimers(-1);
            resetIndexes(-1);
            
            attackTimer = (attackTimer + 1) % animTime;
            if (attackTimer == 0) {
                isAttacking = false;
                setMyImage();
                return;
            }
            
            if (currDirection == NORTH) {
               this.setImage(imgPack.getUpAttack());
            }
            else if (currDirection == EAST) {
               this.setImage(imgPack.getRightAttack());
            }
            else if (currDirection == SOUTH) {
               this.setImage(imgPack.getDownAttack());
            }
            else if (currDirection == WEST) {
               this.setImage(imgPack.getLeftAttack());
            }
        }
    }
    
    /**
     * Resets array indexes and timers for animation purposes.
     * currDirection should be the currDirection being currently animated.
     * 
     * @param currDirection NORTH EAST WEST SOUTH
     *                  => any other string will reset as idle.
     */
    public void resetTimers(int direction) {
        if (direction == NORTH) {
            idleTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction == EAST) {
            upTimer = 0;
            idleTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction == SOUTH) {
            upTimer = 0;
            rightTimer = 0;
            idleTimer = 0;
            leftTimer = 0;
        }
        else if (direction == WEST) {
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            idleTimer = 0;
        }
        else {
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
    }
    
    /**
     * Resets array indexes and timers for animation purposes.
     * currDirection should be the currDirection being currently animated.
     * 
     * @param currDirection NORTH EAST WEST SOUTH
     *                  => any other string will reset as idle.
     */
    public void resetIndexes(int direction) {
        if (direction == NORTH) {
            currIdle = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
        }
        else if (direction == EAST) {
            currUp = 0;
            currIdle = 0;
            currDown = 0;
            currLeft = 0;
        }
        else if (direction == SOUTH) {
            currUp = 0;
            currRight = 0;
            currIdle = 0;
            currLeft = 0;
        }
        else if (direction == WEST) {
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currIdle = 0;
        }
        else {
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
        }
    }
}
