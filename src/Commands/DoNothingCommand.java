package Commands;

/**
 * DoNothingCommand.java
 *
 * Command-class DoNothingCommand.java
 * For some constellations on the Board a Player is not allowed to move any pieces.
 * This class is responsible for handling these actions. (Null-Object Pattern)
 *
 * The class extends the Command-class @see {@link Command}
 *
 * @author Maurice Amon
 */

public class DoNothingCommand extends Command {
    /**
     * Execute the specific command ..
     */
    @Override
    public void execute() {
        // Do nothing ...
    }
}
