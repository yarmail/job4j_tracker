package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemsByName findByName = new FindItemsByName(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Find items by name ---" + ln + item + ln);
    }

    @Test
    public void whenNotFindItemByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String name = "name_Item";
        FindItemsByName findByName = new FindItemsByName(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Find items by name ---" + ln + "Заявок с именем " + name
                + " не найдено" + ln);
    }
}
