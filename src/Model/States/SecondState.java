package Model.States;

import Commands.*;
import Model.Piece;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;
import static Model.PieceNumberDeclaration.SECOND_PIECE;

/**
 * SecondState.java
 *
 * Class SecondState.java
 * Represents the State of the DFA where a player has his first piece on the field and his second Piece
 * in pouch. From this state the DFA can reach the first {@link FirstState}, the fourth {@link FourthState},
 * and the sixth state {@link SixthState}
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class SecondState implements State {

    private Player player;

    public SecondState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        if (roll != 6) {
            moveFirstPiece(roll);
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

    @Override
    public void moveFirstPiece(int roll) {
        Piece firstPiece = player.getPieces().get(FIRST_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(firstPiece, roll);
        command.execute();
        if(firstPiece.getIsAtEndPosition()) {
            player.setState(player.getSixthState());
        }
    }

    @Override
    public void moveSecondPiece(int roll) {
        if(player.getStartPosition() != player.getPieces().get(FIRST_PIECE.getPieceNumber()).getPosition()) {
            Command command = new MovePieceCommand(player.getPieces().get(SECOND_PIECE.getPieceNumber()), roll);
            command.execute();
            player.setState(player.getFourthState());
        } else {
            System.out.println("Move can't be executed. Your own Piece is located there.");
        }
    }

    @Override
    public void sendFirstPieceToPouch() {
        player.setState(player.getStartState());
    }

    @Override
    public void sendSecondPieceToPouch() {
        // This method doesn't need to be implemented ..
        throw new UnsupportedOperationException("Invalid Action");
    }

}
