package ru.job4j.tracker;

/**
 * Делаем рефакторинг класса ValidateInput
 * Заменяем наследование ValidateInput extends ConsoleInput
 * композицией ValidateInput implements Input
 * private final Input input
 */
public class ValidateInput implements Input {
    private final Input input;
    private String question;
    private int[] range;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    public  String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        this.question = question;
        this.range = range;
        int value = this.validate(this.question, this.range);
        return value;
    }

    public int validate(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        } while (invalid);
        return result;
    }
}