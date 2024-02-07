package Model;


import Commands.*;
import Model.States.NinthState;
import Squares.*;

import java.util.*;


/**
 * The Game class
 * This class is responsible for holding and intializing all the relevant components
 * of our game. It also handles the controller functions of initializing the game,
 * determining the state (game is over, current/next player) and the winner of the game.
 *
 * @author Maurice Amon
 */
public class Game {
    // Our static dies
    private static IDie die;

    /**
     * The constant ANSI_RESET.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The constant ANSI_CODE_RED.
     */
    public static final String ANSI_CODE_RED = "\u001B[31m";
    /**
     * The constant ANSI_CODE_GREEN.
     */
    public static final String ANSI_CODE_GREEN = "\u001B[32m";
    /**
     * The constant ANSI_CODE_YELLOW.
     */
    public static final String ANSI_CODE_YELLOW = "\u001B[33m";
    /**
     * The constant ANSI_CODE_BLUE.
     */
    public static final String ANSI_CODE_BLUE = "\u001B[34m";

    /**+
     * int arrays with the path for each player, the elements represent the corresponding index of the square,
     * provided by the ArrayList in the Board class
     */
    private static int[] bluePath = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static int[] redPath = new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5, 26, 27};
    private static int[] yellowPath = new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 1, 2, 3,
            4, 5, 6, 7, 8, 9, 10, 11, 28, 29};
    private static int[] greenPath = new int[]{18, 19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 30, 31};

    /**+
     * int array with the indices of all squares s.t. the order of printing out the board is correct. Also included negative values
     * for \n and other functions relevant to printing the board.
     */
    private int[] printingPath = new int[]{-3, 10, 11, 12, -1, -3, 9, 28, 13, -1, 6, 7, 8, 29, 14, 15, 16, -1, 5, 26, 27, -2, 31, 30,
            17, -1, 4, 3, 2, 25, 20, 19, 18, -1, -3, 1, 24, 21, -1, -3, 0, 23, 22};

    // Deqeue with all the players in the game ..
    private Deque<Player> players;
    // Winner of the game ..
    private Player winner;
    // Current player ..
    private Player currentPlayer;


    // Invariant for making sure that the amount of players the game is initialized with is correct ..
    private boolean invariant() {
        return players.size() == 4;
    }

    /**
     * Instantiates a new Game.
     */
    public Game() {
        // add players ..
        this.addPlayers(initializePlayers());
        currentPlayer = nextPlayer();
        // Instantiate die object ..
        die = new Die(6);
    }

    /**
     * Initialize players queue.
     *
     * @return the queue
     */
    public Queue<Player> initializePlayers() {
        // Create Queue for players ..
        Queue<Player> players = new LinkedList<>();
        // Create blue player ..
        Player player1 = new Player(0, Color.PLAYER_BLUE.toString(), ANSI_CODE_BLUE, bluePath);
        player1.setPiece(new Piece(player1, 1));
        player1.setPiece(new Piece(player1, 2));
        // Add blue player to the queue
        players.add(player1);

        // Create red player ..
        Player player2 = new Player(1, Color.PLAYER_RED.toString(), ANSI_CODE_RED, redPath);
        player2.setPiece(new Piece(player2, 1));
        player2.setPiece(new Piece(player2, 2));
        // Add red player to queue ..
        players.add(player2);

        // Create yellow player ..
        Player player3 = new Player(2, Color.PLAYER_YELLOW.toString(), ANSI_CODE_YELLOW, yellowPath);
        player3.setPiece(new Piece(player3, 1));
        player3.setPiece(new Piece(player3, 2));
        // Add yellow player to queue ..
        players.add(player3);

        // Create green player ..
        Player player4 = new Player(3, Color.PLAYER_GREEN.toString(), ANSI_CODE_GREEN, greenPath);
        player4.setPiece(new Piece(player4, 1));
        player4.setPiece(new Piece(player4, 2));
        // Add green player to queue ..
        players.add(player4);
        return players;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeSquares();

        game.play(die);
    }

    /**
     * Print current board.
     */
    public void printCurrentBoard() {
        System.out.println("\n\n\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // Print pouches ...
        for (Player player : players) {
            for (Piece piece : player.getPieces()) {
                if (piece.getIsInPouch()) {
                    System.out.print(player.getColor() + piece.getPieceNumber() + ANSI_RESET);
                }
            }
            System.out.print(" ");
        }
        System.out.println();
        // Print the entire board ...
        Board board = Board.getBoardInstance();
        for (int i = 0; i < printingPath.length; i++) {
            // The else ifs are important for formatting the board ..
            if (printingPath[i] != -1 && printingPath[i] != -2 && printingPath[i] != -3) {
                System.out.print(board.getSquare(printingPath[i]));
            } else if (printingPath[i] == -1) {
                System.out.println("");
            } else if (printingPath[i] == -2) {
                System.out.print("  ");
            } else if (printingPath[i] == -3) {
                System.out.print("    ");
            }
        }
    }

    /**
     * Initialize squares.
     */
    public void initializeSquares() {
        // Set the start square for player blue
        Board.getBoardInstance().setSquare(new StartSquare(this, 0, Color.PLAYER_BLUE));
        // Set the standardsquare between player blue start square and that of player red ..
        for (int i = 1; i < 6; i++) {
            Board.getBoardInstance().setSquare(new StandardSquare(this, i));
        }
        // Set the start square for player red
        Board.getBoardInstance().setSquare(new StartSquare(this, 6, Color.PLAYER_RED));
        // Set the standardsquare between player red start square and that of player yellow ..
        for (int i = 7; i < 12; i++) {
            Board.getBoardInstance().setSquare(new StandardSquare(this, i));
        }
        // Set the start square for player yellow
        Board.getBoardInstance().setSquare(new StartSquare(this, 12, Color.PLAYER_YELLOW));
        // Set the standardsquare between player yellow start square and that of player green ..
        for (int i = 13; i < 18; i++) {
            Board.getBoardInstance().setSquare(new StandardSquare(this, i));
        }
        // Set the start square for player green
        Board.getBoardInstance().setSquare(new StartSquare(this, 18, Color.PLAYER_GREEN));
        // Set the standardsquare between player green start square and that of player blue ..
        for (int i = 19; i < 24; i++) {
            Board.getBoardInstance().setSquare(new StandardSquare(this, i));
        }
        // Set the Homeroadsquares of all players ...
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 24, Color.PLAYER_BLUE));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 25, Color.PLAYER_BLUE));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 26, Color.PLAYER_RED));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 27, Color.PLAYER_RED));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 28, Color.PLAYER_YELLOW));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 29, Color.PLAYER_YELLOW));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 30, Color.PLAYER_GREEN));
        Board.getBoardInstance().setSquare(new HomeRoadSquare(this, 31, Color.PLAYER_GREEN));
        // Print the board at the beginning of the game ..
        printCurrentBoard();
    }

    /**
     * Play.
     *
     * @param die the die
     */
    public void play(IDie die) {
        // Precondition that die is not null ..
        assert die != null;
        // Execute while loop until the game is over ..
        while (this.notOver()) {
            currentPlayer = nextPlayer();
            System.out.println("\n\n" + currentPlayer.getName() + " it's your turn!");
            // For testing purposes during the development and also for enjoying every move of the game I'll keep these lines
            // here in.
            /*
            Scanner readEnter = new Scanner(System.in);


            String enterkey = readEnter.nextLine();*/

            // Roll the die ..
            int roll = die.roll();
            System.out.println("\n\n" + currentPlayer.getName() + " rolled a " + roll);
            // Initialize the command ..
            initializeMoveCommand(roll);
            // print the board after the execution ..
            printCurrentBoard();
        }
        // Print out the winner of the game ..
        System.out.println("\n\nPlayer " + winner.getName() + " wins the game!");
    }

    /**
     * Initialize move command.
     *
     * @param roll the roll
     */
    public void initializeMoveCommand(int roll) {
        Command command = new StateActionCommand(currentPlayer, roll);
        command.execute();
        // Check if there's a winner ...
        checkWin();
        // check if a player can roll again ..
        checkIfRollAgain(roll, command.getIsAllowedRollAgain());
    }

    private void checkIfRollAgain(int roll, boolean isAllowedToRollAgain) {
        // make sure that the rolled value is valid ..
        assert roll >= 0 && roll <= die.getFaces();
        if (roll == 6 && isAllowedToRollAgain) {
            for (int i = 0; i < 3; i++) {
                nextPlayer();
            }
        }
    }



    /**
     * Checks if we've a winner
     *
     */
    private void checkWin() {
        assert currentPlayer != null;
        // If the current player reached the state where both piece are on Homeroad he wins the game ..
        if (currentPlayer.getState() instanceof NinthState) {
            currentPlayer.wins();
            winner = currentPlayer;
        }
    }


    /**
     * Not over boolean.
     *
     * @return the boolean
     */
    public boolean notOver() {
        return winner == null;
    }

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public boolean isOver() {
        return !this.notOver();
    }

    /**
     * Current player
     *
     * @return the player
     */
    public Player currentPlayer() {
        return currentPlayer;
    }

    /**
     * Winner player.
     *
     * @return the player
     */
    public Player winner() {
        if (!notOver()) {
            return winner;
        }
        return null;
    }

    /**
     * Add all players to the player Queue
     *
     * @param participants Queue of all players we want to participate
     */
    private void addPlayers(Queue<Player> participants) {
        assert participants != null;
        players = new LinkedList<>();
        players.addAll(participants);
        invariant();
    }


    /**
     * Next player player.
     *
     * @return the player
     */
    public Player nextPlayer() {
        assert players != null;
        Player currentPlayer = players.remove(); // remove player from front of queue
        players.add(currentPlayer);
        return currentPlayer;
    }



    /**
     * Gets player by id.
     *
     * @param id the id
     * @return the player by id
     */
    public Player getPlayerById(int id) {
        // Check if the id is valid ...
        assert id >= 0 && id < players.size();
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getid() == id) {
                return player;
            }
        }
        // If the player has not been found give null back.
        return null;
    }

}
