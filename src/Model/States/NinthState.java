package Model.States;

import Model.Player;

/**
 * NinthState.java
 *
 * Class NinthState.java
 * Represents the State of the DFA where a player has both his first and second Piece
 * on the Homeroad. It marks the final state of the DFA where the player has won the game.
 *
 * The state itself does not over any useful operations itself. :)
 *
 * @see {@link State}
 *
 * @author Maurice Amon
 */

public class NinthState implements State {

    private Player player;

    public NinthState(Player player) {
        this.player = player;
    }


    @Override
    public void action(int roll) {
        // Does not have to be implemented ..
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveFirstPiece(int roll) {
        // Does not have to be implemented ..
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveSecondPiece(int roll) {
        // Does not have to be implemented ..
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendFirstPieceToPouch() {
        // Does not have to be implemented ..
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendSecondPieceToPouch() {
        // Does not have to be implemented ..
        throw new UnsupportedOperationException();
    }

}
