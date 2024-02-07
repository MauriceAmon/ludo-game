package Model.States;

import Commands.*;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;

/**
 * FirstState.java
 *
 * Class FirstState.java
 * Represents the State of the DFA where a player has both of his Pieces in pouch.
 * The state can reach the second {@link SecondState} and the third stage {@link ThirdState}.
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class FirstState implements State {

    private Player player;

    public FirstState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        if(roll == 6) {
            moveFirstPiece(roll);
        }
    }

    @Override
    public void moveFirstPiece(int roll) {
        Command command = new MovePieceCommand(player.getPieces().get(FIRST_PIECE.getPieceNumber()), roll);
        command.execute();
        player.setState(player.getSecondState());
    }

    @Override
    public void moveSecondPiece(int roll) {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendFirstPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    @Override
    public void sendSecondPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

}
