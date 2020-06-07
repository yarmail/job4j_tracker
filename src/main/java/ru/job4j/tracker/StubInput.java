package ru.job4j.tracker;

/**
 * Class StubInput - interface implementation and test Input
 * Реализация интерфейса Input. Проверка работы кода.
 */
public class StubInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. {"0", "name", "desc", "6"}
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Override ask()
     * Переопределяем метод ask
     * Подставляем тестовые значения из StartUITest
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
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
