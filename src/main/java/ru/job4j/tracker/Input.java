package ru.job4j.tracker;

/**
 * interface Input
 * Создает метод ask для реализацци его разными классами
 * Все интерфейсы имеют доступ public
 */
interface Input {

    /**
     * The ask method asks the user for information.
     * Метод ask запрашивает у пользователя информацию
     */
    String ask(String question);

    int ask(String question, int[] range);

}
