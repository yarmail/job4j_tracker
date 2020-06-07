package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Через эмулятор StubInput тестируем StartUI
 */
public class StartUITest {
    /**
     * Для рефакторинга переносим повторяющиеся переменные в поля класса
     */
    private final Tracker tracker = new Tracker();
    private final Item item = tracker.add(new Item("test name", "desc", 12345));

    /**
     * Подключаем переменные для перенапрвления вывода
     */
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };



    /**
     * Подключаем меню для влючения в буфер
     */
    private final String menu = new StringJoiner(System.lineSeparator())
            .add("0.Add new order")
            .add("1.Show all order")
            .add("2.Edit order")
            .add("3.Delete order")
            .add("4.Find order by ID")
            .add("5.Find order by name")
            .toString();



    /**
     * Show all orders
     * Показываем все заявки
     * assertThat:
     * out.toString() - реальныый выход (actual)
     * is(new StringJoiner(System.lineSeparator()) - меню, которе мы создали (expected)
     */
    @Test
    public void showAllTest() {
        System.setOut(new PrintStream(this.out));
        String[] answer = new String[] {"1", "y"};
        Input input = new StubInput(answer);
        new StartUI(input, tracker, output).init();
        assertThat(out.toString(), is(new StringJoiner(System.lineSeparator())
                .add(menu)
                .add("------------ List of all orders --------------")
                .add("ID: " + item.getId() + " Name: " + item.getName() + " Created: " + item.getTime())
                .add("------------ End of list orders --------------")
                .add("")
                .toString()
        ));
        System.setOut(this.stdout);
    }

    @Test
    public void findByIdTest() {
        Input input = new StubInput(new String[] {"4", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));

    }

    @Test
    public void findByNameTest() {
        Input input = new StubInput(new String[] {"5", "test name", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findByName("test name").size(), is(1));
    }

    /**
     * addItemTest
     * Когда пользователь добавляет заявку,
     * тогда трекер имеет новую заявку с некоторым именем
     *
     * Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
     * Переопределяем input через StubInput
     * и задаем последовательность действий пользователя
     *
     * new StartUI(input, tracker).init();
     * создаём StartUI и вызываем метод init()
     *
     * assertThat(tracker.findAll()[0].getName(), is("test name"));
     * ИНТЕРЕСНО СФОРМУЛИРОВАНО
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void addItemTest() {
        Input input = new StubInput(new String[] {"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * editItemTest
     * Когда пользователь меняет заявку - она меняется в трекере
     *
     * Item item = tracker.add(new Item("test name", "desc", 12345));
     * ИНТЕРЕСНО СФОРМУЛИРОВАНО
     * напрямую добавляем заявку в массив трекера
     *
     * Input input = new StubInput(new String[] {"2", item.getId(), "new name", "new desc", "6"});
     * создаём StubInput с последовательностью действий (производим замену заявки)
     *
     * new StartUI(input, tracker).init();
     * создаём StartUI и вызываем метод init()
     *
     * tracker.findById(item.getId()).getName(),
     * ИНТЕРЕСНО СФОРМУЛИРОВАНО
     *
     */
    @Test
    public void editItemTest() {
        Input input = new StubInput(new String[] {"2", item.getId(), "new name", "new desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("new name"));
    }

    /**
     * Если пользователем удаляется элемент, то длина результирующего массива = 0
     */
    @Test
    public void deleteTest() {
        Input input = new StubInput(new String[] {"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        List<Item> result = tracker.findByName("test name");
        assertThat((result.size()), is(0));
    }
}