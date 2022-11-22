package ru.job4j.tracker;

import java.sql.SQLException;

public class EditItemAction implements UserAction {
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("--- Edit item ---");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка заменена");
        } else {
            out.println("Ошибка замены заявки");
        }
        return true;
    }
}
