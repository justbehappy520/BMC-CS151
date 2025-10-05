import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Class that tests the PostfixEvaluator.
 *  @author Adam Poliak
 **/
public class TestPostfixEvaluator {

    /** Tests multiplication.
    * @result 9 9 * should be 81
    * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
    */
    @Test
    public void testMult() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 *";
        assertEquals(81, evaluator.eval(line));
    }

    /** Tests division.
     * @result 9 9 / should be 1
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testDivide() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 /";
        assertEquals(1, evaluator.eval(line));
    }

    /** Tests addition.
     * @result 9 9 + should be 18
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testAdd() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 +";
        assertEquals(18, evaluator.eval(line));
    }

    /** Tests subtraction.
     * @result 9 9 - should be 0
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testSub() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 -";
        assertEquals(0, evaluator.eval(line));
    }

    //todo: add 4 more tests here. They should combine multiple operators
    /** Tests multiplication and division.
     * @result 9 9 * 9 / 9 * 9 / should be 9
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testMultDivide() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 * 9 / 9 * 9 /";
        assertEquals(9, evaluator.eval(line));
    }

    /** Tests multiplication and addition.
     * @result 9 9 * 9 + 9 + should be 99
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testMultAdd() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 * 9 + 9 +";
        assertEquals(99, evaluator.eval(line));
    }

    /** Tests everything.
     * @result 9 9 + 9 - 9 * 9 / should be 9
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testRand() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 + 9 - 9 * 9 /";
        assertEquals(9, evaluator.eval(line));
    }

    /** Tests addition and subtraction.
     * @result 9 9 + 9 - 9 + should be 18
     * @throws PostfixEvaluator.SyntaxErrorException if syntax is off
     */
    @Test
    public void testAddSub() throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String line = "9 9 + 9 - 9 +";
        assertEquals(18, evaluator.eval(line));
    }
}
