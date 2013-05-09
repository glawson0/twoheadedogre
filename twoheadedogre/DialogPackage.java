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
    private boolean dialogPlaying;
    
    public DialogPackage()
    {
        dialogPlaying = false;
    }
    
    /**
     * Must pass classType as a string
     *  ex: playDialog("knight",face); for a knight spawning with dialog.
     * Gordo is the face variable, telling us which ogre is being controlled at the moment.
     *  This allows us to switch between dialogs if we so wish.
     */
    public void playDialog(String classType, boolean gordo) {
        if (!dialogPlaying) {
            if (classType.equals("ogre")) {
                // randomly generate a number
                // set dialogPlaying to true
                // play a dialog corresponding to that number
                // set dialogPlaying to false
                if (gordo) {
                    // Gordo (stuuuupid)
                }
                else {
                    // Omak (smart.)
                }
            }
            else if (classType.equals("knight")) {
                // randomly generate a number
                // set dialogPlaying to true
                // play a dialog corresponding to that number
                // set dialogPlaying to false
            }
            else if (classType.equals("archer")) {
                // randomly generate a number
                // set dialogPlaying to true
                // play a dialog corresponding to that number
                // set dialogPlaying to false
            }
        }
    }
}
