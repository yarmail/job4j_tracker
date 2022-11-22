package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateItemXAction implements UserAction {
    private final Output out;

    public CreateItemXAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add x items.";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        out.println("Create X items");
        int n = input.askInt("Введите количество заявок, которые надо добавить: ");
        for (int i = 0; i <= n; i++) {
            memTracker.add(new Item("Name" + i));
        }
        return true;
    }
}
