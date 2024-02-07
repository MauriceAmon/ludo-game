package Model.States;

import Commands.*;
import Model.Piece;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;


/**
 * SeventhState.java
 *
 * Class SeventhState.java
 *
 * Represents the State of the DFA where a player has his first piece on the field and his second Piece
 * in the Homeroad. From this state the DFA can reach the fifth {@link FifthState}
 * and the ninth state {@link NinthState}
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class SeventhState implements State {

    private Player player;

    public SeventhState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        moveFirstPiece(roll);
    }

    @Override
    public void moveFirstPiece(int roll) {
        Piece firstPiece = player.getPieces().get(FIRST_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(firstPiece, roll);
        command.execute();
        if(firstPiece.getIsAtEndPosition()) {
            player.setState(player.getNinthState());
        }
    }

    @Override
    public void moveSecondPiece(int roll) {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    @Override
    public void sendFirstPieceToPouch() {
        player.setState(player.getFifthState());
    }

    @Override
    public void sendSecondPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

}
