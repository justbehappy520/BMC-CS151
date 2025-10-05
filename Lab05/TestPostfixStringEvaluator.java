import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Class that tests PostfixStringEvaluator.
 */
public class TestPostfixStringEvaluator {

    /**
     * Tests multiplication.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testMult() throws PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "99 9 *";
        assertEquals("( 99 * 9 )", evaluator.eval(line));
    }

    /**
     * Tests when there are two operands.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testTwoOperands() throws 
        PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "5 6 + 9 *";
        assertEquals("( ( 5 + 6 ) * 9 )", evaluator.eval(line));
    }

    /**
     * Tests when there are three operands in a row.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testThreeOperandsInARow() throws 
        PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "8 9 10 + *";
        assertEquals("( ( 9 + 10 ) * 8 )", evaluator.eval(line));
    }

    // todo: add 4 more tests here. They should combine multiple operators
    /**
     * Tests when there are three operators.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testThreeOperators() throws 
        PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "8 9 * 10 + 11 -";
        assertEquals("( ( ( 8 * 9 ) + 10 ) - 11 )", evaluator.eval(line));
    }

    /**
     * Tests when there are four operands.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testFourOperands() throws 
        PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "8 9 10 11 - + /";
        assertEquals("( 8 / ( 9 + ( 10 - 11 ) ) )", evaluator.eval(line));
    }
    
    /**
     * Tests when there are random.
     * @throws PostfixStringEvaluator.SyntaxErrorException if wrong syntax
     */
    @Test
    public void testRand() throws 
        PostfixStringEvaluator.SyntaxErrorException {
        PostfixStringEvaluator evaluator = new PostfixStringEvaluator();
        String line = "8 9 + 10 - 11 - 12 + 13 /";
        assertEquals("( ( ( ( ( 8 + 9 ) - 10 ) - 11 ) + 12 ) / 13 )",
            evaluator.eval(line));
    }
}
