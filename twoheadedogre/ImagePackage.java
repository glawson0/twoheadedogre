import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImagePackage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImagePackage
{    
    /* Image packs for all movement images. */
    private GreenfootImage[] idleImages;
    private int currIdle, idleTimer;
    private GreenfootImage[] upImages;
    private int currUp, upTimer;
    private GreenfootImage[] rightImages;
    private int currRight, rightTimer;
    private GreenfootImage[] downImages;
    private int currDown, downTimer;
    private GreenfootImage[] leftImages;
    private int currLeft, leftTimer;
    
    /* Single images for attack animations. */
    private GreenfootImage upAttack;
    private GreenfootImage rightAttack;
    private GreenfootImage downAttack;
    private GreenfootImage leftAttack;
    
    /* Integer flags for timing animations. */
    int isIdle;
    int isMovingUp;
    int isMovingRight;
    int isMovingDown;
    int isMovingLeft;
    
    /**
     * Default constructor is empty.
     * Set all values through construtor methods below.
     */
    public ImagePackage()
    {
       isIdle = 1;
       isMovingUp = 0;
       isMovingRight = 0;
       isMovingDown = 0;
       isMovingLeft = 0;
    }
    
    /**
     * Set _ image array. This assumes that you have provided image
     * file (in the 'images' folder) named 'basenameN.suffix', where N is
     * [0..numberOfImages-1].
     * 
     * @param basename  The base name of the image files.
     * @param suffix  The suffix of the image files (must include the ".").
     * @param noOfImages  The number of images to be use din the animation.
     */
    public void SetupIdleImages(String basename, String suffix, int noOfImages)
    {
        idleImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            idleImages[i] = new GreenfootImage(basename + i + suffix);
        }
        currIdle = 0;
        idleTimer = 0;
    }
    public void SetupUpImages(String basename, String suffix, int noOfImages)
    {
        upImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            upImages[i] = new GreenfootImage(basename + i + suffix);
        }
        currUp = 0;
        upTimer = 0;
    }
    public void SetupRightImages(String basename, String suffix, int noOfImages)
    {
        rightImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            rightImages[i] = new GreenfootImage(basename + i + suffix);
        }
        currRight = 0;
        rightTimer = 0;
    }
    public void SetupDownImages(String basename, String suffix, int noOfImages)
    {
        downImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            downImages[i] = new GreenfootImage(basename + i + suffix);
        }
        currDown = 0;
        downTimer = 0;
    }
    public void SetupLeftImages(String basename, String suffix, int noOfImages)
    {
        leftImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            leftImages[i] = new GreenfootImage(basename + i + suffix);
        }
        currLeft = 0;
        leftTimer = 0;
    }
    
    /**
     * Set _ attack image. This assumes that you have provided image
     * file (in the 'images' folder) named 'filename'.
     * 
     * @param filename  The name of the image file.
     * @param direction The direction the attack image is for.
     */
    public void SetupAttackImage(String filename, String direction)
    {
        if (direction.equals("up")) {
           upAttack = new GreenfootImage(filename);
        }
        else if (direction.equals("right")) {
           rightAttack = new GreenfootImage(filename);
        }
        else if (direction.equals("down")) {
           downAttack = new GreenfootImage(filename);
        }
        else if (direction.equals("left")) {
           leftAttack = new GreenfootImage(filename);
        }
    }
    
    /**
     * Getter method to receive the next correct image actor should set.
     * 
     * @param direction "up" "right" "down" "left"
     *                  => any other string will return an idle set image.
     */
    public GreenfootImage getImage(String direction) {
        if (direction.equals("up")) {
            resetCounters("up");
            upTimer = (upTimer + 1) % 60;
            if (upTimer == 0)
               currUp = (currUp + 1) % upImages.length;
            return (upImages[currUp]);
        }
        else if (direction.equals("right")) {
            resetCounters("right");
            rightTimer = (rightTimer + 1) % 60;
            if (rightTimer == 0)
               currRight = (currRight + 1) % rightImages.length;
            return (rightImages[currRight]);
        }
        else if (direction.equals("down")) {
            resetCounters("down");
            downTimer = (downTimer + 1) % 60;
            if (downTimer == 0)
               currDown = (currDown + 1) % downImages.length;
            return (downImages[currDown]);
        }
        else if (direction.equals("left")) {
            resetCounters("left");
            leftTimer = (leftTimer + 1) % 60;
            if (leftTimer == 0)
               currLeft = (currLeft + 1) % leftImages.length;
            return (leftImages[currLeft]);
        }
        else {
            resetCounters("idle");
            idleTimer = (idleTimer + 1) % 60;
            if (idleTimer == 0)
               currIdle = (currIdle + 1) % idleImages.length;
            return (idleImages[currIdle]);
        }
    }
    
    /**
     * Resets array indexes and timers for animation purposes.
     * Direction should be the direction being currently animated.
     * 
     * @param direction "up" "right" "down" "left"
     *                  => any other string will reset as idle.
     */
    public void resetCounters(String direction) {
        if (direction.equals("up")) {
            currIdle = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
            idleTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("right")) {
            currUp = 0;
            currIdle = 0;
            currDown = 0;
            currLeft = 0;
            upTimer = 0;
            idleTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("down")) {
            currUp = 0;
            currRight = 0;
            currIdle = 0;
            currLeft = 0;
            upTimer = 0;
            rightTimer = 0;
            idleTimer = 0;
            leftTimer = 0;
        }
        else if (direction.equals("left")) {
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currIdle = 0;
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            idleTimer = 0;
        }
        else { // idle image set case
            currUp = 0;
            currRight = 0;
            currDown = 0;
            currLeft = 0;
            upTimer = 0;
            rightTimer = 0;
            downTimer = 0;
            leftTimer = 0;
        }
    }
    
    /**
     * Basic getter method for attack iamges.
     */
    public GreenfootImage getUpAttack() {
        return upAttack;
    }
    public GreenfootImage getRightAttack() {
        return rightAttack;
    }
    public GreenfootImage getDownAttack() {
        return downAttack;
    }
    public GreenfootImage getLeftAttack() {
        return leftAttack;
    }
}
