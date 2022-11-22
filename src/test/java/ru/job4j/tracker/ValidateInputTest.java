package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = {input.askInt("Enter menu:"), input.askInt("Enter id: ")};
        int[] expected = {1, 4};
        Assert.assertArrayEquals(expected, selected);
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }
}

