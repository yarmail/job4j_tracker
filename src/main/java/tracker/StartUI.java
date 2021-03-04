package tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Store tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Store tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init(UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker, output);
        }
    }
    private void showMenu(UserAction[] actions) {
        output.accept("Menu." + System.lineSeparator());
        for (int index = 0; index < actions.length; index++) {
            output.accept(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(),
                    new FindAllAction(),
                    new ReplaceAction(),
                    new DeleteAction(),
                    new FindByIdAction(),
                    new FindByNameAction(),
                    new ExitAction()
            };
            new StartUI(validate, tracker, System.out::println).init(actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}