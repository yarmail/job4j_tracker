package learn.ex;

import learn.ex.Fact;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartFactFalseArg() {
        new Fact().calc(-1);
    }
}
