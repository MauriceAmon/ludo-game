package Commands;

import Model.PieceNumberDeclaration;
import Model.Player;

import java.util.Scanner;

/**
 * ChoosePieceCommand.java
 *
 * Command-class ChoosePieceCommand.java
 * Let's the Player choose which Piece he wants to move ..
 *
 * ChoosePieceCommand.java reads one sign from the command line in @see {@link #execute()} method 1 and 2 are expected
 * for the corresponding pieces, if the user enters something different, he has to enter a correct input again.
 *
 * The class extends the Command-class @see {@link Command}
 *
 * @author Maurice Amon
 */
public class ChoosePieceCommand extends Command {

    private Player player;

    private final String FIRST_CHOICE = "1";

    private final String SECOND_CHOICE = "2";


    /**
     * Instantiates a new Choose piece controller.
     *
     * @param player  the player
     */
    public ChoosePieceCommand(Player player) {
        this.player = player;
    }
    /**
     * Execute the specific command ..
     */
    @Override
    public void execute() {
        Scanner readEnter = new Scanner(System.in);

        String enterkey = "Press 1 or 2 for moving the respective piece: ";
        System.out.print(enterkey);


        enterkey = readEnter.nextLine();
        System.out.print(enterkey);

        if (enterkey.equals(FIRST_CHOICE)) {
            affectedPiece = PieceNumberDeclaration.FIRST_PIECE.getPieceNumber();
        } else if(enterkey.equals(SECOND_CHOICE)) {
            affectedPiece = PieceNumberDeclaration.SECOND_PIECE.getPieceNumber();
        } else {
            execute();
        }
    }
}
