package learn.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionLamTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionLam.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResult() {
        List<Double> result = FunctionLam.diapason(3, 7, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(10D, 17D, 26D, 37D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDemoFunctionThenDemoResult() {
        List<Double> result = FunctionLam.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}
