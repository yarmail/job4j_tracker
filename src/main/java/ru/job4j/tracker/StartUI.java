package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            snowMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    public void snowMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }

    }

    public static void main(String[] args) throws SQLException {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new CreateAction(output), new CreateItemXAction(output), new FindAllAction(output),
                new EditItemAction(output), new DeleteItemAction(output), new DeleteItemXAction(output),
                new FindItemById(output), new FindItemsByName(output),
                new CloseProgramAction(output)
        ));
        new StartUI(output).init(input, tracker, actions);
    }
}
