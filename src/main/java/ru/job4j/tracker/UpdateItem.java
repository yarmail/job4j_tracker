package ru.job4j.tracker;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept(String.format("%s%n", "------------ Edit Order --------------"));
        String id = input.ask("Please enter the ID of the order for edit");
        String name = input.ask("Please enter the new name of the order");
        String desc = input.ask("Please enter the new description of the order");
        long created = System.currentTimeMillis();
        Item item = new Item(name, desc, created);
        boolean result = tracker.replace(id, item);
        if (result) {
            output.accept(String.format("%s%n", "------------ The order with number : " + item.getId() + " has been edited"));
        }
        if (!result) {
            output.accept(String.format("%s%n", "------------ Edit operation failed --------------"));
        }
    }
}