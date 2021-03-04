package tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        String name = input.askStr("Enter a name to search: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            output.accept(items.size() + " item(s) found with the name(s):");
            for (Item item : items) {
                output.accept(item.getName());
            }
        } else {
            output.accept("Items with this name not found.");
        }
        return true;
    }
}
