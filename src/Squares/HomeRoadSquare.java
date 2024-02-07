package Squares;

import Model.*;

/**
 * Squares.HomeRoadSquare.java
 *
 * Square-class HomeRoadSquare.java
 * Represents a Homeroad square of a {@link Model.Player} route.
 * To distinguish the players this class provides a Color attribute
 *
 * HomeRoadSquare inherits from {@link StandardSquare} which implements {@link Square} interface.
 *
 * @author Maurice Amon
 */
public class HomeRoadSquare extends StandardSquare {

    // Color of the HomeRoadSquare ..
    private Color homeRoadColor;


    /**
     * Instantiates a new Home road square.
     *
     * @param game          the game
     * @param position      the position
     * @param homeRoadColor the home road color
     */
    public HomeRoadSquare(Game game, int position, Color homeRoadColor) {
        super(game, position);
        this.homeRoadColor = homeRoadColor;
        isHomeRoadSquare = true;
        initializeAnsiColor();
    }


    /**
     * Initializes the color
     *
     */
    private void initializeAnsiColor() {
        assert homeRoadColor != null;

        switch (homeRoadColor) {
            case PLAYER_BLUE:
                ansiColor = Game.ANSI_CODE_BLUE;
                break;
            case PLAYER_YELLOW:
                ansiColor = Game.ANSI_CODE_YELLOW;
                break;
            case PLAYER_RED:
                ansiColor = Game.ANSI_CODE_RED;
                break;
            case PLAYER_GREEN:
                ansiColor = Game.ANSI_CODE_GREEN;
                break;
        }
    }

    /**
     * Checks if the square is a homeroadsquare ..
     *
     * @return boolean returns true
     */
    @Override
    public boolean isHomeRoadSquare() {
        return isHomeRoadSquare;
    }
}
