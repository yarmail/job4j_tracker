package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput - interface implementation Input
 * Реализация интерфейса Input
 * В этой реализации мы используем
 * System.in - консольный ввод - данные от пользователя
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод ask - Реализация интерфейса Input
     * возвращает данные от пользователя
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}