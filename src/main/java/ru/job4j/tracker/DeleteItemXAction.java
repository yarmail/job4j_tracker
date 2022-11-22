package ru.job4j.tracker;

import java.sql.SQLException;

public class DeleteItemXAction implements UserAction {
    private final Output out;

    public DeleteItemXAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete x items.";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        out.println("---Delete items---");
        int id = input.askInt("Введите id, до которого надо удалять заявки: ");
        for (int i = 0; i < id; i++) {
            memTracker.delete(i);
        }
        return true;
    }
}
