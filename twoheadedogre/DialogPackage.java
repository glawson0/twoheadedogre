/**
 * Dialog package is for storyline dialog.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogPackage  
{
    /**
     * When dialog plays, set to true. 
     * When dialog is finished, set back to false.
     * This stops the problem of overlaying dialog.
     */
    private boolean dialogPlaying;
    
    /**
     * Constructor for objects of class DialogPackage
     */
    public DialogPackage()
    {
        dialogPlaying = false;
    }
    
    
    public void playDialog(String classType) {
        if (!dialogPlaying) {
            if (classType.equals("ogre")) {
                // randomly generate a number
                // set dialogPlaying to true
                // play a dialog corresponding to that number
                // set dialogPlaying to false
            }
            else if (classType.equals("knight")) {
                // randomly generate a number
                // set dialogPlaying to true
                // play a dialog corresponding to that number
                // set dialogPlaying to false
            }
        }
    }
}
