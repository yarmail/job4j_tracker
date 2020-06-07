package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept(String.format("%s%n", "------------ Delete Order --------------"));
        String id = input.ask("Please enter the ID of the order for delete");
        boolean result = tracker.delete(id);
        if (result) {
            output.accept(String.format("%s%n", "------------ The delete operation was successful --------------"));
        }
        if (!result) {
            output.accept(String.format("%s%n", "------------ Delete operation failed --------------"));
        }
    }
}