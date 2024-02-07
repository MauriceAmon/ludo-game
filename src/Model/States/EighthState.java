package Model.States;

import Commands.*;
import Model.Piece;
import Model.Player;

import static Model.PieceNumberDeclaration.*;

/**
 * EightState.java
 *
 * Class EightState.java
 * Represents the State of the DFA where a player has his first Piece on a Homeroad-square and the second one
 * on the Field.
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */


public class EighthState implements State {

    private Player player;

    public EighthState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        // Player can only move the second piece, so there's no choice ..
        moveSecondPiece(roll);
    }

    @Override
    public void moveFirstPiece(int roll) {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    @Override
    public void moveSecondPiece(int roll) {
        // Execute the move ..
        Piece secondPiece = player.getPieces().get(SECOND_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(secondPiece, roll);
        command.execute();
        // Check if the second piece has reached a Homeroad-Square ..
        if(secondPiece.getIsAtEndPosition()) {
            // If so, change the state of the DFA to the final state ..
            player.setState(player.getNinthState());
        }
    }

    @Override
    public void sendFirstPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    @Override
    public void sendSecondPieceToPouch() {
        player.setState(player.getSixthState());
    }

}
