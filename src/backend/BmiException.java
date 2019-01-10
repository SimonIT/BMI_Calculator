package backend;

/**
 * short description
 *
 * @author wolke
 * @version 1.0, 28.09.2012
 */
public class BmiException extends Exception {

    /**
     * @param reason reason for the exception
     */
    public BmiException(String reason) {
        super(reason);
    }

}
