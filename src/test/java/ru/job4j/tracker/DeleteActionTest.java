package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteItemAction dia = new DeleteItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        dia.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Delete item ---" + ln + "Заявка удалена." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteItemWithIncorrectIndex() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteItemAction dia = new DeleteItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(5);
        dia.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("--- Delete item ---" + ln + "Ошибка удаления заявки." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(1);
    }
}
