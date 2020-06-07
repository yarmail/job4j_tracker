package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Написать интерфейс UserAction,
 * в котором определить методы, общие для всех событий.
 */
interface UserAction {

    /**
     *  Метод возвращает ключ опции.
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker, Consumer<String> output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}