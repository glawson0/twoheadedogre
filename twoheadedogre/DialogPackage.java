import greenfoot.*;
import java.util.Random;

/**
 * Dialog package is for storyline dialog.
 * 
 * @author Robin Verweij
 * @version super beta
 */
public class DialogPackage  
{
    /**
     * When dialog plays, set to true. 
     * When dialog is finished, set back to false.
     * This stops the problem of overlaying dialog.
     */
    private boolean ogreDialogPlaying;
    private boolean humanDialogPlaying;
    private Random r;
    
    private int currPlayedTime;
    private final int soundPlayTime = 250;
    
    public DialogPackage(Random r)
    {
        this.r = r;
        currPlayedTime = 0;
        ogreDialogPlaying = false;
        humanDialogPlaying = false;
    }
    
    public void dialogAct() {
        currPlayedTime = (currPlayedTime + 1) % soundPlayTime;
        if (currPlayedTime == 0) {
           ogreDialogPlaying = false;
           humanDialogPlaying = false;
        }
    }
    
    /**
     * Must pass classType as a string
     *  ex: playDialog("knight",face); for a knight spawning with dialog.
     * Gordo is the face variable, telling us which ogre is being controlled at the moment.
     *  This allows us to switch between dialogs if we so wish.
     */
    public void playDialog(String classType, boolean gordo) {
        // randomly generate a number
        // set dialogPlaying to true
        // play a dialog corresponding to that number
        if (!ogreDialogPlaying && classType.equals("ogre")) {
            if (gordo) {
               ogreDialogPlaying = true;
               String whichOne = Integer.toString(r.nextInt(9));
               Greenfoot.playSound("gordo"+whichOne+".wav");
            }
            else {
               ogreDialogPlaying = true;
               String whichOne = Integer.toString(r.nextInt(8));
               Greenfoot.playSound("omak"+whichOne+".wav");
            }
        }
        else if (!humanDialogPlaying && (classType.equals("knight") || classType.equals("archer"))) {
            humanDialogPlaying = true;
            String whichOne = Integer.toString(r.nextInt(7));
            Greenfoot.playSound("human"+whichOne+".wav");
        }
    }
}
