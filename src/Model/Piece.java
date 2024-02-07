package Model;


import Model.States.State;

/**
 * + Model.Piece.java
 * Model-class Model.Piece
 * <p>
 * Represents one of the two Pieces a {@link Model.Player} can have.
 *
 * @author Maurice Amon
 */

public class Piece {

    // Number of the piece ..
    private Integer pieceNumber;
    // player to which the piece belongs
    private Player player = null;
    // position of the piece on the board ..
    private Integer position;
    // bool which marks if the piece is at a homeroadsquare
    private Boolean isAtEndPosition = false;
    // bool which marks if the piece is in pouch
    private Boolean isInPouch = true;

    private Boolean isOnBoard = false;

    /**
     * Instantiates a new Piece.
     *
     * @param player      the player
     * @param pieceNumber the piece number
     */
    public Piece(Player player, Integer pieceNumber) {
        assert player != null && pieceNumber != null;
        this.player = player;
        this.pieceNumber = pieceNumber;
    }

    /**
     * + Gets the Model.Player of the piece
     *
     * @return player player
     */
    public Player getPlayer() {
        assert player != null;
        return player;
    }

    /**
     * Sets position of a piece that was in pouch before
     *
     * @param position the position
     */
    public void setStartPosition(int position) {
        assert position >= 0;
        Piece piece = Board.getBoardInstance().getSquare(position).getPiece();
        // If there's already a opponents piece, set it back to pouch.
        if (piece != null) {
            Board.getBoardInstance().getSquare(position).leave(piece);
            piece.setReturnPouch();
        }
        // Set new position, that the piece has left the pouch and enter the new square.
        this.position = position;
        setLeftPouch();
        Board.getBoardInstance().getSquare(this.position).enter(this);
    }

    /**
     * Moves piece.
     *
     * @param moves the moves
     * @return the int
     */
    public int movePiece(int moves) {
        assert moves >= 0;
        // Get if there is already a piece on the target square ..
        Piece piece = Board.getBoardInstance().getSquare(player.getPath()[player.getIndexOfPathElement(position) + moves]).getPiece();
        // If there is no piece ..
        if (piece == null) {
            Board.getBoardInstance().getSquare(position).leave(this);
            this.position = player.getPath()[player.getIndexOfPathElement(position) + moves];
            if (Board.getBoardInstance().getSquare(position).isHomeRoadSquare()) {
                setArrivedAtEndPosition();
            }
            Board.getBoardInstance().getSquare(position).enter(this);
        }
        // Else if player's id of the piece is not the same as of the piece on the target position,
        // reset the piece to pouch and place piece of current piece on the position ..
        else if (this.player.getid() != piece.getPlayer().getid()) {
            Board.getBoardInstance().getSquare(position).leave(this);
            Board.getBoardInstance().getSquare(piece.getPosition()).leave(piece);
            piece.setReturnPouch();
            piece.position = null;
            this.position = player.getPath()[player.getIndexOfPathElement(position) + moves];
            Board.getBoardInstance().getSquare(position).enter(this);
        }
        // If a piece of the same player is on the target square, print out warning ..
        else {
            System.out.println("Auf dem Spielfeld befindet sich bereits eine Figur! Ihre Figur verharrt auf derselben Position.");
        }
        return moves;
    }

    /**
     * + Gets the Position of the piece
     *
     * @return position position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * + Checks if the piece is at its goal
     *
     * @return the is at end position
     */
    public Boolean getIsAtEndPosition() {
        return isAtEndPosition;
    }

    /**
     * + Sets that a piece is at its goal
     */
    public void setArrivedAtEndPosition() {
        isOnBoard = false;
        isAtEndPosition = true;
    }

    /**
     * + Sets that a piece has left its pouch
     */
    public void setLeftPouch() {
        this.isInPouch = false;
        setOnBoard();
    }

    /**
     * Sets return pouch.
     */
    public void setReturnPouch() {
        State cs = player.getState();
        if(pieceNumber.equals(PieceNumberDeclaration.FIRST_PIECE.getPieceNumber()+1)) {
            cs.sendFirstPieceToPouch();
        } else {
            cs.sendSecondPieceToPouch();
        }
        isInPouch = true;
        isOnBoard = false;
    }

    /**
     * + Sets that a piece has left its pouch and is on Board
     */
    public void setOnBoard() {
        this.isOnBoard = true;
    }

    /**
     * + Checks if the piece is still in Pouch
     *
     * @return isInPouch is in pouch
     */
    public Boolean getIsInPouch() {
        return isInPouch;
    }

    /**
     * Gets is on board.
     *
     * @return the is on board
     */
    public Boolean getIsOnBoard() {
        return isOnBoard;
    }

    /**
     * Gets piece number.
     *
     * @return the piece number
     */
    public Integer getPieceNumber() {
        return pieceNumber;
    }

    public String toString() {
        return pieceNumber.toString();
    }

}
