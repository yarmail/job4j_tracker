package tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        String id = input.askStr("Enter id to delete item: ");
        String msg = (tracker.delete(id)) ? "Item with this id deleted." : "Item with this id not found.";
        output.accept(msg);
        return true;
    }
}
