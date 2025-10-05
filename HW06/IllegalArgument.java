/**
 * A class that throws errors when the arguments are wrong.
 */
public class IllegalArgument extends RuntimeException {
    /**
     * A method that spells an error when arguments have issues.
     * 
     * @param error is the error message
     */
    public IllegalArgument(String error) {
        super(error);
    }
}
