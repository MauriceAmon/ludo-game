package Model.States;

import Commands.*;
import Model.Player;

import static Model.PieceNumberDeclaration.SECOND_PIECE;

/**
 * SixthState.java
 *
 * Class SixthState.java
 * Represents the State of the DFA where a player has his first piece on the Homeroad and his second Piece
 * in pouch. From this state the DFA can reach the eighth state {@link EighthState}.
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class SixthState implements State {

    private Player player;

    public SixthState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        if(roll == 6) {
            moveSecondPiece(roll);
        }
    }

    @Override
    public void moveFirstPiece(int roll) {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    @Override
    public void moveSecondPiece(int roll) {
        Command command = new MovePieceCommand(player.getPieces().get(SECOND_PIECE.getPieceNumber()), roll);
        command.execute();
        player.setState(player.getEightState());
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
