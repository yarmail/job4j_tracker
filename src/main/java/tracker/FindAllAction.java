package tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindAllAction implements UserAction  {
    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            output.accept(items.size() + " item(s) found.");
            for (Item item:items) {
                output.accept(System.lineSeparator() + "Name: " + item.getName());
                output.accept("Id: " + item.getId());
            }
        } else {
            output.accept("No items found");
        }
        return true;
    }
}
