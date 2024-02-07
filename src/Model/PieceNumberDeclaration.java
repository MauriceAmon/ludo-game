package Model;

/**
 * The enum Piece number declaration.
 *
 * @author Maurice Amon
 */
public enum PieceNumberDeclaration {
    /**
     * First piece number declaration.
     */
    FIRST_PIECE(0),
    /**
     * Second piece number declaration.
     */
    SECOND_PIECE(1);

    private final int pieceNumber;


    private PieceNumberDeclaration(int number) {
        pieceNumber = number;
    }

    /**
     * Gets piece number.
     *
     * @return the piece number
     */
    public int getPieceNumber() {
        return pieceNumber;
    }
}
