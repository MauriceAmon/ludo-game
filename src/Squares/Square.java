package Squares;

import Model.Piece;

/**
 * Interface for all squares ...
 * <p>
 * Provides all methods every Square should have.
 */
public interface Square {


    /**
     * Tests if square is start square of player blue ..
     *
     * @return the boolean
     */
    boolean isBlueFirstSquare();

    /**
     * Is red first square boolean.
     *
     * @return the boolean
     */
    boolean isRedFirstSquare();

    /**
     * Is green first square boolean.
     *
     * @return the boolean
     */
    boolean isGreenFirstSquare();

    /**
     * Is yellow first square boolean.
     *
     * @return the boolean
     */
    boolean isYellowFirstSquare();

    /**
     * Verifies if this is an instance of HomeRoadSqaure.
     *
     * @return the boolean
     */
    boolean isHomeRoadSquare();


    /**
     * Piece enters the square.
     *
     * @param piece the piece
     */
    void enter(Piece piece);


    /**
     * Piece leaves the square.
     *
     * @param piece the piece
     */
    void leave(Piece piece);

    /**
     * Gets piece.
     *
     * @return the piece
     */
    Piece getPiece();

}
