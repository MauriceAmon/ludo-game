package Model.States;

import Commands.*;
import Model.Piece;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;
import static Model.PieceNumberDeclaration.SECOND_PIECE;

/**
 * ThirdState.java
 *
 * Class ThirdState.java
 *
 * Represents the State of the DFA where a player has his first piece in pouch and his second Piece
 * on the field. From this state the DFA can reach the first {@link FirstState}, the fourth {@link FourthState},
 * and the fifth state {@link FifthState}
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class ThirdState implements State {

    private Player player;

    public ThirdState(Player player) {
        this.player = player;
    }
    /**
     * @param roll
     */
    @Override
    public void action(int roll) {
        if (roll != 6) {
            moveSecondPiece(roll);
        } else {
            Command command = new ChoosePieceCommand(player);
            command.execute();
            if(command.getAffectedPiece() == SECOND_PIECE.getPieceNumber()) {
                moveSecondPiece(roll);
            } else if(command.getAffectedPiece() == FIRST_PIECE.getPieceNumber()) {
                moveFirstPiece(roll);
            }
        }

    }

    /**
     * @param roll
     */
    @Override
    public void moveFirstPiece(int roll) {
        if(player.getStartPosition() != player.getPieces().get(SECOND_PIECE.getPieceNumber()).getPosition()) {
            Command command = new MovePieceCommand(player.getPieces().get(FIRST_PIECE.getPieceNumber()), roll);
            command.execute();
            player.setState(player.getFourthState());
        } else {
            System.out.println("Move can't be executed. Your own Piece is located there.");
        }
    }

    /**
     * @param roll
     */
    @Override
    public void moveSecondPiece(int roll) {
        Piece secondPiece = player.getPieces().get(SECOND_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(secondPiece, roll);
        command.execute();
        if(secondPiece.getIsAtEndPosition()) {
            player.setState(player.getFifthState());
        }
    }

    /**
     *
     */
    @Override
    public void sendFirstPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

    /**
     *
     */
    @Override
    public void sendSecondPieceToPouch() {
        player.setState(player.getStartState());
    }
}
