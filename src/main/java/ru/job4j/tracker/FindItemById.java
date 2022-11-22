package ru.job4j.tracker;

import java.sql.SQLException;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("--- Find item by id ---");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка под id " + id
                    + " не найдена.");
        }
        return true;
    }
}
