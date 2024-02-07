package Model.States;

import Commands.*;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;

/**
 * FifthState.java
 *
 * Class FifthState.java
 * Represents the State of the DFA where a player has his first Piece in pouch and the second one
 * on a Homeroad-square.
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class FifthState implements State {

    private Player player;

    public FifthState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        // Player can only move a piece, if he has rolled a 6 ..
        if(roll == 6) {
            moveFirstPiece(roll);
        }
    }

    @Override
    public void moveFirstPiece(int roll) {
        Command command = new MovePieceCommand(player.getPieces().get(FIRST_PIECE.getPieceNumber()), roll);
        command.execute();
        player.setState(player.getSeventhState());
    }

    @Override
    public void moveSecondPiece(int roll) {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
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
