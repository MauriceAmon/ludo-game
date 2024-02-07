package Model;

import Model.IDie;

/**
 * Represents the die in the game.
 *
 * @author Dominique Freidig
 */
public class Die implements IDie {
    private final int faces;

    /**
     * Constructs a die with given faces.
     *
     * @param faces: number of sides > 0
     */
    public Die(int faces) {
        assert(faces > 0);
        this.faces = faces;
    }

    /**
     * Rolls the dice and returns the number rolled.
     *
     * @return result: the number rolled
     */
    @Override
    public int roll() {
        int result = 1 + (int) (faces * Math.random());
        return result;
    }

    /**
     *
     * @return faces: the number rolled
     */
    public int getFaces() {
        return faces;
    }
}
