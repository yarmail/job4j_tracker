package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all items.";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        List<Item> items = tracker.findAll();
        out.println("--- Show all items ---");
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
