package Model;


/**
 * The enum Color.
 */
public enum Color {

    /**
     * Player blue color.
     */
    PLAYER_BLUE("Blue"),
    /**
     * Player red color.
     */
    PLAYER_RED("Red"),
    /**
     * Player green color.
     */
    PLAYER_GREEN("Green"),
    /**
     * Player yellow color.
     */
    PLAYER_YELLOW("Yellow");

    private final String playerName;

    /**
     * @param name The name/color of the player ..
     */
    private Color(String name) {
        playerName = name;
    }

    public String toString() {
        return playerName;
    }
}
