package Model.States;

import Squares.Square;

/**
 * State.java
 *
 * Interface State.java
 * Provides an interface for all states in Deterministic Finite Automaton for the player's choices
 *
 * A piece can be located at three differnet stages during the game: In the pouch, on the field and on a Homeroad-square.
 * Since a piece can't be moved anymore after reaching the Homeroad, there's no need for corresponding methods.
 **
 * @author Maurice Amon
 */
public interface State {

    /**
     * Handles the action for the current State based on the rolled number ..
     *
     * @param roll the number a player has rolled
     */
    void action(int roll);

    /**
     * Prepares and executes a move for the first piece.
     * Also executes the state-change that may result.
     *
     * @param roll the number a player has rolled
     */
    void moveFirstPiece(int roll);

    /**
     * Prepares and executes a move for the second piece.
     * Also executes the state-change that may result.
     *
     * @param roll the number a player has rolled
     */
    void moveSecondPiece(int roll);

    /**
     * Sends the first piece of a player back to pouch,
     * Also executes the state-change that may result.
     *
     */
    void sendFirstPieceToPouch();

    /**
     * Sends the second piece of a player back to pouch,
     * Also executes the state-change that may result.
     *
     */
    void sendSecondPieceToPouch();


}
