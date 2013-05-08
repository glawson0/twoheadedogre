import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sound actor will play conflicting sounds, such as battle noises and deaths.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundActor extends AnimatedActor
{
    private static final int framesBetweenSound = 10;
    private boolean soundPlayed;
    private int soundTimer;
    
    public SoundActor(ImagePackage imgPack) {
        super(imgPack);
        soundPlayed = false;
        soundTimer = 0;
    }
    
    /**
     * Act - do whatever the SoundActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if (soundPlayed) {
            soundTimer = (soundTimer + 1) % framesBetweenSound;
            if (soundTimer == 0) {
                soundPlayed = false;
            }
        }
        
        if (Greenfoot.isKeyDown("a")) {
            if (soundTimer == 0) {
                //playAttackSound();
                soundPlayed = true;
            }
        }
    }
    
    public void playAttackSound() {
        if (this instanceof Knight) {
            Greenfoot.playSound("");
        }
        else if (this instanceof Ogre) {
            Greenfoot.playSound("");
        }
    }
}
