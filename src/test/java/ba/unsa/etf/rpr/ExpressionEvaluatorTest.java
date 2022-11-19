package ba.unsa.etf.rpr;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExpressionEvaluatorTest {
    ExpressionEvaluator eval = new ExpressionEvaluator();

    @Test
    public void evaluateTest() {
        assertEquals(eval.evaluate("( 1 + 1 )"), 2.0);
    }

    @Test
    public void evaluateTest1() {
        assertEquals(eval.evaluate("( 1 - ( 12 + ( 1 - 3 ) ) )"), -9.0);
    }

    @Test
    public void evaluateTest2() {
        assertEquals(eval.evaluate("( 3 + ( 17 * ( 1 + 1 ) ) )"), 37.0);
    }

    @Test
    public void evaluateTest3() {
        assertEquals(eval.evaluate("( 1 / 4 )"), 0.25);
    }

    @Test
    public void evaluateTest4() {
        assertEquals(eval.evaluate("( 12 + ( sqrt ( 3 * 3 ) ) )"), 15.0);
    }

    @Test
    public void RunTimeExceptionTest() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            eval.evaluate("( 12-(knl)) )");
        }, "Neispravan izraz!");
    }
}
