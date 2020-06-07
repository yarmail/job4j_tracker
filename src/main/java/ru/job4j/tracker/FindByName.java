package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept(String.format("%s%n", "------------ Find Order by Name --------------"));
        String name = input.ask("Please enter the Name of the order for find: ");

        List<Item> result = tracker.findByName(name);
        if (result.size() == 0) {
            output.accept(String.format("%s%n", "------------ Order not found --------------"));
        }
        if (result.size() > 0) {
            for (Item el : result) {
                output.accept(String.format("%s%n", "Id: " + el.getId() + " Name: " + el.getName() + " Created: " + el.getTime()));
            }
        }
    }
}
