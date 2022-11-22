package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenAsc() {
        List<Item> items = Arrays.asList(
                new Item("n"),
                new Item("s"),
                new Item("c"),
                new Item("d")
        );
        List<Item> expected = Arrays.asList(
                new Item("c"),
                new Item("d"),
                new Item("n"),
                new Item("s")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(expected, is(items));
    }
}
