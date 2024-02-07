package Model;

/**
 * Represents the Mock die for testing the game.
 *
 * @author Maurice Amon
 */
public class MockDie implements IDie {

    private int[] dieSequence;

    private int counter = -1;


    /**
     * Constructs a die with a given sequence
     *
     * @param dieSequence int array with sequence of die faces
     */
    public MockDie(int[] dieSequence) {
        this.dieSequence = dieSequence;
    }

    /**
     * Rolls the Mock die and returns the number rolled.
     *
     * @return result: the number rolled
     */
    @Override
    public int roll() {
        counter++;
        return dieSequence[counter];
    }

    /**
     * Gets the amount of faces of the die
     *
     * @return amount of faces
     */
    @Override
    public int getFaces() {
        return 6;
    }


}
