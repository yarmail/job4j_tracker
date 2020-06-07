package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept(String.format("%s%n", "------------ Find Order by ID --------------"));
        String id = input.ask("Please enter the ID of the order for find: ");
        Item result = tracker.findById(id);
        if (result == null) {
            output.accept(String.format("%s%n", "------------ Order not found --------------"));
        }
        if (result != null) {
            output.accept(String.format("%s%n", "Find Order Id: " + result.getId() + " Name: " + result.getName() + " Created: " + result.getTime()));
        }
    }
}