package ru.job4j.tracker;

/**
 * Создать класс MenuOutException,
 * наследующий RuntimeException который должен
 * принимать сообщение об ошибке в конструктор
 * и передавать его в конструктор родителя.
 *
 * Таким образом мы создаем собственную ошибку,
 * которая нам нужна, в данном случае выход
 * выбора пользователя за пределы диапазона меню выбора
 */
public class MenuOutException extends RuntimeException {

    public MenuOutException(String msg) {
        super(msg);
    }
}