package Commands;

/**
 * + Command.java
 * Abstract class which all controllers have to extend
 *
 * @author Maurice Amon
 */
public abstract class Command {

    protected Boolean isAllowedRollAgain = true;

    protected int affectedPiece;

    /**
     * Execute the specific command ..
     */
    public abstract void execute();

    public Boolean getIsAllowedRollAgain() {
        return isAllowedRollAgain;
    }

    public int getAffectedPiece() {
        return affectedPiece;
    }
}
