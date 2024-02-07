package Squares;

import Model.Game;
import Model.Piece;
import Model.Player;


/**
 * Squares.StandardSquare.java
 *
 * Square-class StandardSquare.java
 * Represents a Standardsquare of a {@link Model.Player} route.
 *
 * StandardSquare implements {@link Square} interface and provides concrete implementations for all its subclass.
 *
 * {@link HomeRoadSquare} and {@link StartSquare}
 *
 * @author Maurice Amon
 */
public class StandardSquare implements Square {
    /**
     * Position in the game
     */
    protected int position;

    /**
     * The Ansi color.
     */
    protected String ansiColor = "\u001B[37m";

    /**
     * The Is home road square.
     */
    protected boolean isHomeRoadSquare = false;

    /**
     * The Game.
     */
    public Game game;

    /**
     * The Player.
     */
    protected Player player;

    /**
     * The Piece.
     */
    protected Piece piece;

    private boolean invariant() {
        return game != null;
    }

    /**
     * Instantiates a new Standard square.
     *
     * @param game     the game
     * @param position the position
     */
    public StandardSquare(Game game, int position) {
        assert game != null;
        assert position >= 0;

        this.game = game;
        this.position = position;

        assert invariant();
    }

    @Override
    public Piece getPiece() {
        return piece;
    }


    public String toString() {
        if(piece != null) {
            return ansiColor +"[" + Game.ANSI_RESET + this.piece.getPlayer().getColor() + this.piece + Game.ANSI_RESET +
                    ansiColor + "]" + Game.ANSI_RESET;
        }
        return ansiColor +"[" + Game.ANSI_RESET + ansiColor + "]" + Game.ANSI_RESET ;
    }

    /**
     * Piece enters the square.
     *
     * @param piece the piece
     */
    @Override
    public void enter(Piece piece) {
        assert this.piece == null;
        this.player = piece.getPlayer();
        this.piece = piece;
    }

    /**
     * Piece leaves the square.
     *
     * @param piece the piece
     */
    @Override
    public void leave(Piece piece) {
        assert this.piece == piece;
        this.player = null;
        this.piece = null;
    }

    public boolean isBlueFirstSquare() {
        return false;
    }

    @Override
    public boolean isRedFirstSquare() {
        return false;
    }

    @Override
    public boolean isGreenFirstSquare() {
        return false;
    }

    @Override
    public boolean isYellowFirstSquare() {
        return false;
    }

    @Override
    public boolean isHomeRoadSquare() {
        return false;
    }

}
