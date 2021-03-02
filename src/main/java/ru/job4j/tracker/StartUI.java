package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * input - Получение данных от пользователя.
 * tracker - Хранилище заявок.
 * ?? output = System.out::println ??
 */

public class StartUI {
    private final Input input;
    private final MemTracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, MemTracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select number: ", menu.range()));
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());

        try (Store tracker = new SqlTracker()){
            tracker.init();
            UserAction[] actions = {new CreateAction()};
            new StartUI().init(validate,tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}