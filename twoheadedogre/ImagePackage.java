import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Holds all images pertaining to a certain actor's animation. 
 * Can be shared between actors without synchronization of animations.
 * 
 * @author Robin Verweij
 * @version 1
 */
public class ImagePackage
{    
    /* Image packs for all movement images. */
    private GreenfootImage[] idleImages;
    private GreenfootImage[] upImages;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] downImages;
    private GreenfootImage[] leftImages;
    
    /* Single images for attack animations. */
    private GreenfootImage upAttack;
    private GreenfootImage rightAttack;
    private GreenfootImage downAttack;
    private GreenfootImage leftAttack;
    
    /**
     * Default constructor is empty.
     * Set all values through construtor methods below.
     */
    public ImagePackage() { }
    
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
    }
    public void SetupUpImages(String basename, String suffix, int noOfImages)
    {
        upImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            upImages[i] = new GreenfootImage(basename + i + suffix);
        }
    }
    public void SetupRightImages(String basename, String suffix, int noOfImages)
    {
        rightImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            rightImages[i] = new GreenfootImage(basename + i + suffix);
        }
    }
    public void SetupDownImages(String basename, String suffix, int noOfImages)
    {
        downImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            downImages[i] = new GreenfootImage(basename + i + suffix);
        }
    }
    public void SetupLeftImages(String basename, String suffix, int noOfImages)
    {
        leftImages = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            leftImages[i] = new GreenfootImage(basename + i + suffix);
        }
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
     * @param index     The index specifying what image to grab.
     */
    public GreenfootImage getImage(String direction, int index) {
        if (direction.equals("up")) 
            return (upImages[index]);
        else if (direction.equals("right"))
            return (rightImages[index]);
        else if (direction.equals("down"))
            return (downImages[index]);
        else if (direction.equals("left"))
            return (leftImages[index]);
        else
            return (downImages[0]);
    }
    
    /**
     * Getter method to receive the length of the image array
     * associated with the specified direction.
     * 
     * @param direction "up" "right" "down" "left"
     *                  => any other string will return -1
     */
    public int imgArrayLen(String direction) {
        if (direction.equals("up")) 
            return upImages.length;
        else if (direction.equals("right"))
            return rightImages.length;
        else if (direction.equals("down"))
            return downImages.length;
        else if (direction.equals("left"))
            return leftImages.length;
        else
            return -1;
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
