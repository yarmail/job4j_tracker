package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() throws SQLException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store memTracker = new MemTracker();
        List<UserAction> actions = asList(
                new CreateAction(output),
                new CloseProgramAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        Assert.assertEquals(memTracker.findAll().get(0).getName(), "Item name");
    }

    @Test
    public void whenEditedItem() throws SQLException {
        Output output = new ConsoleOutput();
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Edited item", "1"}
        );
        List<UserAction> actions = asList(
                new EditItemAction(output),
                new CloseProgramAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        Assert.assertEquals(memTracker.findAll().get(0).getName(), "Edited item");
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        Output output = new ConsoleOutput();
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = asList(
                new DeleteItemAction(output),
                new CloseProgramAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        Assert.assertNull(null, memTracker.findById(1));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = asList(
                new EditItemAction(out),
                new CloseProgramAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit program" + ln
                        + "--- Edit item ---" + ln
                        + "Заявка заменена" + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit program" + ln
                        + "---Exit program---" + ln
        ));
    }

    @Test
    public void whenFindAllItemsTestOutput() throws SQLException {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Item two = memTracker.add(new Item("test2"));
        Item three = memTracker.add(new Item("test3"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = asList(
                new FindAllAction(out),
                new CloseProgramAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find all items." + ln
                        + "1. Exit program" + ln
                        + "--- Show all items ---" + ln
                        + one + ln + two + ln + three + ln + "Menu:" + ln
                        + "0. Find all items." + ln
                        + "1. Exit program" + ln
                        + "---Exit program---" + ln
        ));
    }

    @Test
    public void whenFindByNameItemsTestOutput() throws SQLException {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Err"));
        Item two = memTracker.add(new Item("Sell"));
        Item three = memTracker.add(new Item("A"));
        Item four = memTracker.add(new Item("Sell"));
        Input in = new StubInput(
                new String[] {"0", "Sell", "1"}
        );
        List<UserAction> actions = asList(
                new FindItemsByName(out),
                new CloseProgramAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit program" + ln
                        + "--- Find items by name ---" + ln
                        + two + ln + four + ln + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit program" + ln
                        + "---Exit program---" + ln
        ));
    }

    @Test
    public void whenFindByIdItemsTestOutput() throws SQLException {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Err"));
        Item two = memTracker.add(new Item("Sell"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(two.getId()), "1"}
        );
        List<UserAction> actions = asList(
                new FindItemById(out),
                new CloseProgramAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id." + ln
                        + "1. Exit program" + ln
                        + "--- Find item by id ---" + ln
                        + two + ln + "Menu:" + ln
                        + "0. Find item by id." + ln
                        + "1. Exit program" + ln
                        + "---Exit program---" + ln
        ));
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = asList(
                new CloseProgramAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit program" + ln
                                + "---Exit program---" + ln
                )
        );
    }
}

