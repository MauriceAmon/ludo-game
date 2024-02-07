package Squares;

import Model.Color;
import Model.Game;

/**
 * Squares.StartSquare.java
 *
 * Square-class StartSquare.java
 * Represents a StartSquare of a players {@link Model.Player} route.
 *
 * StartSquare extends {@link StandardSquare} class and has a color to determine to which player it belongs to.
 *
 * {@link StandardSquare}, {@link Square} and {@link Color}
 *
 * @author Maurice Amon
 */
public class StartSquare extends StandardSquare{

    private Color color;

    /**
     * Initialize with the host game and position in it
     *
     * @param game     game of which this square is a part of, must not be null
     * @param position position of this square in the game, must be >= 1
     * @param color    the color
     */
    public StartSquare(Game game, int position, Color color) {
        super(game, position);
        this.color = color;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}
