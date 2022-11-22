package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("--- Delete item ---");
        int id = input.askInt("Enter id item: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
