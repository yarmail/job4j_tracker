package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemDescByNameTest {

    @Test
    public void whenDesc() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("b"),
                new Item("c"),
                new Item("d")
        );
        List<Item> expected = Arrays.asList(
                new Item("d"),
                new Item("c"),
                new Item("b"),
                new Item("a")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(expected, is(items));
    }
}
