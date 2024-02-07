package Model;

import Model.States.*;

import java.util.ArrayList;

/**
 * + Model.Player.java
 * Model-class Model.Player
 * <p>
 * Represents one of the four Players in the game.
 *
 * @author Maurice Amon
 */
public class Player {

    // Id of the player ...
    private Integer id;
    // name of the player ..
    private String name;
    // color of the player ..
    private String color;
    // pieces of the player ..
    private ArrayList<Piece> pieces;
    // road path of the player ..
    private int[] path;
    // players start position ..
    private int startPosition;
    // boolean for is the player the winner ..
    private boolean isWinner;

    private FirstState firstState;

    private SecondState secondState;

    private ThirdState thirdState;

    private FourthState fourthState;

    private FifthState fifthState;

    private SixthState sixthState;

    private SeventhState seventhState;

    private EighthState eightState;

    private NinthState ninthState;

    private final Integer STATE_1 = 1;

    private final Integer STATE_2 = 2;

    private final Integer STATE_3 = 3;

    private final Integer STATE_4 = 4;

    private final Integer STATE_5 = 5;

    private final Integer STATE_6 = 6;

    private final Integer STATE_7 = 7;

    private final Integer STATE_8 = 8;

    private final Integer STATE_9 = 9;

    private State currentState;

    /**
     * Instantiates a new Player.
     *
     * @param id    the id
     * @param name  the name
     * @param color the color
     * @param path  the path
     */
    public Player(int id, String name, String color, int[] path) {
        firstState = new FirstState(this);
        secondState = new SecondState(this);
        thirdState = new ThirdState(this);
        fourthState = new FourthState(this);
        fifthState = new FifthState(this);
        sixthState = new SixthState(this);
        seventhState = new SeventhState(this);
        eightState = new EighthState(this);
        ninthState = new NinthState(this);
        currentState = firstState;
        this.id = id;
        this.name = name;
        this.path = path;
        startPosition = path[0];
        this.color = color;
        pieces = new ArrayList<>();
    }

    /**
     * Get path int [ ].
     *
     * @return the int [ ]
     */
    public int[] getPath() {
        assert path != null;
        return path;
    }

    /**
     * Gets index of path element.
     *
     * @param x the x
     * @return the index of path element
     */
    public int getIndexOfPathElement(int x) {
        for(int i = 0; i < path.length; i++) {
            if(path[i] == x) {
                return i;
            }
        }
        // In case the index has not been found we give back
        // a value bigger than the size of the board
        return 100;
    }


    /**
     * + Gets the id of the player
     *
     * @return id
     */
    public Integer getid() {
        assert id != null;
        return id;
    }

    /**
     * + Gets the name of the player
     *
     * @return name name
     */
    public String getName() {
        assert name != null;
        return name;
    }

    /**
     * + Gets the color of the player
     *
     * @return color color
     */
    public String getColor() {
        assert color != null;
        return color;
    }

    /**
     * + Gets the arraylist of the pieces of the player
     *
     * @return pieces pieces
     */
    public ArrayList<Piece> getPieces() {
        assert pieces != null;
        return pieces;
    }

    /**
     * + Assigns a piece to the player
     *
     * @param piece the piece
     */
    public void setPiece(Piece piece) {
        assert piece != null;
        this.pieces.add(piece);
    }

    /**
     * Gets start position.
     *
     * @return the start position
     */
    public int getStartPosition() {
        return startPosition;
    }


    /**
     * Wins.
     */
    public void wins() {
        isWinner = true;
    }

    /** Sets the next state of the DFA ..
     *
     * @param nextState
     */
    public void setState(State nextState) {
        this.currentState = nextState;
    }

    public State getState() {
        return currentState;
    }


    public FirstState getStartState() {
        return firstState;
    }

    public SecondState getSecondState() {
        return secondState;
    }

    public ThirdState getThirdState() {
        return thirdState;
    }


    public FourthState getFourthState() {
        return fourthState;
    }

    public FifthState getFifthState() {
        return fifthState;
    }

    public SixthState getSixthState() {
        return sixthState;
    }

    public SeventhState getSeventhState() {
        return seventhState;
    }

    public EighthState getEightState() {
        return eightState;
    }

    public NinthState getNinthState() {
        return ninthState;
    }



}
