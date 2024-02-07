package Model;

/**
 * The Die interface
 * Die serves as an interface of {@link Model.Die} (the one we use in the application)
 * as well as {@link Model.MockDie} which I've created for testing purposes.
 *
 * @author Maurice Amon
 */
public interface IDie {

    /**
     * Roll die.
     *
     * @return the die face
     */
    int roll();

    /**
     * Gets the amount of faces of the die
     *
     * @return amount of faces
     */
    int getFaces();
}
