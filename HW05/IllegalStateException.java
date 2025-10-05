/**
 * A class that notifies user of an illegal state.
 */
public class IllegalStateException 
    extends RuntimeException {
    /**
     * Error message.
     * @param error notifies user of the problem
     */
    public IllegalStateException(String error) {
        super(error);
    }
}
