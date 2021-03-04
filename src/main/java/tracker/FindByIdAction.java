package tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        String id = input.askStr("Enter id to search from item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("Found item with id: " + item.getId());
            output.accept("Name: " + item.getName());
        } else {
            output.accept("Item with this id not found.");
        }
        return true;
    }
}
