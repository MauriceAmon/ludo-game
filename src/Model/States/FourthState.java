package Model.States;

import Commands.*;
import Model.Piece;
import Model.PieceNumberDeclaration;
import Model.Player;

import static Model.PieceNumberDeclaration.FIRST_PIECE;
import static Model.PieceNumberDeclaration.SECOND_PIECE;

/**
 * FourthState.java
 *
 * Class FourthState.java
 * Represents the State of the DFA where a player has both his first and second Piece
 * on the Field. From this state the DFA can reach the second {@link SecondState}, the third {@link ThirdState},
 * the seventh {@link SeventhState} and the eight state {@link EighthState}
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */
public class FourthState implements State {

    private Player player;

    public FourthState(Player player) {
        this.player = player;
    }

    @Override
    public void action(int roll) {
        Command command = new ChoosePieceCommand(player);
        command.execute();
        if(command.getAffectedPiece() == PieceNumberDeclaration.FIRST_PIECE.getPieceNumber()) {
            moveFirstPiece(roll);
        } else if(command.getAffectedPiece() == PieceNumberDeclaration.SECOND_PIECE.getPieceNumber()) {
            moveSecondPiece(roll);
        }
    }

    @Override
    public void moveFirstPiece(int roll) {
        Piece firstPiece = player.getPieces().get(FIRST_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(firstPiece, roll);
        command.execute();
        if(firstPiece.getIsAtEndPosition()) {
            player.setState(player.getEightState());
        }
    }

    @Override
    public void moveSecondPiece(int roll) {
        Piece secondPiece = player.getPieces().get(SECOND_PIECE.getPieceNumber());
        Command command = new MovePieceCommand(secondPiece, roll);
        command.execute();
        if(secondPiece.getIsAtEndPosition()) {
            player.setState(player.getSeventhState());
        }
    }

    @Override
    public void sendFirstPieceToPouch() {
        player.setState(player.getThirdState());
    }

    @Override
    public void sendSecondPieceToPouch() {
        player.setState(player.getSecondState());
    }

}
