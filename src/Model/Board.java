package Model;

import Squares.HomeRoadSquare;
import Squares.Square;
import Squares.StartSquare;


import java.util.ArrayList;


/**
 * Board.java
 *
 * Model-class Board.java
 * Provides an ArrayList with all Squares {@link Square} of the game.
 *
 * Board.java class has been implemented according to the Singleton pattern, since we only
 * need one instance during the runtime. However, for reasons of further extensions (a new game functionality for example)
 * it also provides a method for destroying the current instance @see {@link #destroyBoardInstance()}
 *
 * @see {@link Square}
 *
 * @author Maurice Amon
 */
public class Board  {

    private static Board board;

    private final ArrayList<Square> SQUARES = new ArrayList<>();

    private Board() {

    }

    /**
     * Gets board instance.
     *
     * @return the board instance
     */
    public static Board getBoardInstance() {
        if(board == null) {
            board = new Board();
        }
        return board;
    }

    /**
     * Static method for destroying the current Board instance
     *
     */
    public static void destroyBoardInstance() {
        board = null;
    }

    /**
     * Sets square.
     *
     * @param square the square
     */
    public void setSquare(Square square) {
        // square can't be null
        assert square != null;
        SQUARES.add(square);
    }

    /**
     * Gets square.
     *
     * @param index the index
     * @return the square
     */
    public Square getSquare(int index) {
        // Precondition that the index is valid ..
        assert index >= 0 && index <= SQUARES.size();
        return SQUARES.get(index);
    }



}
