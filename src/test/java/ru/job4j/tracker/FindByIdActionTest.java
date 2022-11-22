package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.iterable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFindItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemById findItemById = new FindItemById(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findItemById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Find item by id ---" + ln + item + ln);
    }

    @Test
    public void whenNotFindItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindItemById findItemById = new FindItemById(out);
        Input input = mock(Input.class);
        int id = 3;
        when(input.askInt(any(String.class))).thenReturn(id);
        findItemById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Find item by id ---" + ln + "Заявка под id " + id
                + " не найдена." + ln);
    }
}
