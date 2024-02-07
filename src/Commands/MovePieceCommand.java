package Commands;

import Model.Board;
import Model.Piece;
import Model.Player;
import Squares.Square;

/**
 * MovePieceCommand.java
 *
 * Command-class MovePieceCommand.java
 * Moves the piece of a Player @see {@link Player} and @see {@link Piece}
 *
 * The class extends the Command-class @see {@link Command}
 *
 * @author Maurice Amon
 */
public class MovePieceCommand extends Command {

    private Piece piece;

    private int moves;

    /** Instantiates a MovePieceCommand
     *
     * @param piece the piece
     * @param moves the moves
     */
    public MovePieceCommand(Piece piece, int moves) {
        this.piece = piece;
        this.moves = moves;
    }

    /**+
     * Execute the specific command ..
     */
    @Override
    public void execute() {
        Player player = piece.getPlayer();
        int index = checkIsIndexValid();
        if (index != -1) {
            if (piece.getIsInPouch()) {
                piece.setStartPosition(piece.getPlayer().getPath()[0]);
            } else {
                piece.movePiece(moves);
            }
        } else {
            System.out.println("\n\nYou need the exact number (and no 6! in order to reach the Homeroad!");
        }
    }

    /**+
     * Check if the index is valid ..
     *
     * @return int depending on the returned int we can evaluate if the move can be executed or not ..
     */
    private int checkIsIndexValid() {
        // If the piece has no position and is in the pouch
        if (piece.getPosition() == null && piece.getIsInPouch()) {
            return 0;
        }
        // If the piece is not in the pouch and the position is not null
        else if (!piece.getIsInPouch() && piece.getPosition() != null) {
            // If the index of the target square still belongs to the board ..
            if (piece.getPlayer().getIndexOfPathElement(piece.getPosition()) + moves < piece.getPlayer().getPath().length) {
                Board board = Board.getBoardInstance();
                Square square = board.getSquare(piece.getPlayer().getPath()[piece.getPlayer().getIndexOfPathElement(piece.getPosition()) + moves]);
                if(square.isHomeRoadSquare() && moves == 6) {
                    isAllowedRollAgain = false;
                    return -1;
                }
                return 0;
            }
        }
        return -1;
    }
}
