import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sound actor will play conflicting sounds, such as battle noises and deaths.
 * 
 * @author Robin Verweij
 * @version not yet done
 */
public class SoundActor extends AnimatedActor
{
    private static final int framesBetweenSound = 30;
    private boolean soundPlayed;
    private int soundTimer;
    
    public SoundActor(ImagePackage imgPack) {
        super(imgPack);
        soundPlayed = false;
        soundTimer = 0;
    }
    
    public void act() 
    {
        super.act();
        if (soundPlayed) {
            soundTimer = (soundTimer + 1) % framesBetweenSound;
            if (soundTimer == 0) {
                soundPlayed = false;
            }
        }
        else if (isAttacking) {
            if (soundTimer == 0) {
                playAttackSound();
                soundPlayed = true;
            }
        }
    }
    
    public void playAttackSound() {
        if (this instanceof Knight) {
            Greenfoot.playSound("swordSwing.wav");
        }
        else if (this instanceof Ogre) {
            Greenfoot.playSound("ogreHit.wav");
        }
        else if(this instanceof Archer) {
            Greenfoot.playSound("arrowShot.wav");
        }
    }
}
