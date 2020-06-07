package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private final Consumer<String> output;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

     /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(0, new AddItem(0, "Add new order"));
        this.actions.add(1, new ShowAllItem(1, "Show all order"));
        this.actions.add(2, new UpdateItem(2, "Edit order"));
        this.actions.add(3, new DeleteItem(3, "Delete order"));
        this.actions.add(4, new FindById(4, "Find order by ID"));
        this.actions.add(5, new FindByName(5, "Find order by name"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответcтвующее действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * Массив с числами пунктов меню
     * @return int[] array
     */

    public int[] range() {
        int[] range = new int[this.actions.size()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        return range;
    }
}