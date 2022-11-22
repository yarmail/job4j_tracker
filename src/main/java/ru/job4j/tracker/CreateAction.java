package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("---Create item---");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Заявка добавлена: " + item);
        return true;
    }
}
