package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    /**
     * Тестируем generateId()
     *
     * Как я понимаю требования к генератору:
     * 1) ID должны сортироваться.
     * 2) Следующее сгенерированное число должно быть всегда строго больше предущего
     * на время тестирования поменняли private на public
     * на текущий момент currentTimeMillis = 1557501092803 (13 знаков) (long 19 знаков)
     * через пару минут currentTimeMillis  = 1557501655404 (6 знаков поменялось)
     * Для данной задачи думаю можно сделать Math.random в пределах 4 знаков
     * в крупных проектах возможно нужно использовать nanoTime()
     * с бОльшим диапазоном Math.random
     */
    @Test
    public void generateIdTest() {
       // тестирование проводилось с доступом public
       // для доступа private тестирование отменено
    }

    /**
     * Test Add new application
     * Метод добавляет новую заявку в хранилище
     *
     * Добавляем заявку и проверяем что она там есть
     * (по именам)
     */
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "test1Description", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Test Search by id
     * Поиск по id
     * Если найдено правильно - имя заявок будут совпадать
     */
    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "test1Description", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Test getting a list of all applications
     * Тест Получение списка всех заявок
     * Создаем три заявки и ищем их
     * Должно быть 3.
     */
    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        long created1 = System.currentTimeMillis();
        long created2 = System.currentTimeMillis();
        long created3 = System.currentTimeMillis();
        Item item1 = new Item("test1", "test1Description", created1);
        Item item2 = new Item("test2", "test2Description", created2);
        Item item3 = new Item("test3", "test3Description", created3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findAll();
        assertThat((result.size()), is(3));
    }

    /**
     * Test Search in array by name
     * Поиск в массиве по полю Name
     *
     * Создаем три заявки. У первой и третьей заявки поле Name одинаково
     * В результате количество найденных заявок должно быть две.
     */
    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        long created1 = System.currentTimeMillis();
        long created2 = System.currentTimeMillis();
        long created3 = System.currentTimeMillis();
        Item item1 = new Item("test1", "test1Description", created1);
        Item item2 = new Item("test2", "test2Description", created2);
        Item item3 = new Item("test1", "test1Description", created3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName("test1");
        assertThat((result.size()), is(2));
    }

    /**
     * Test Delete applications
     * Тест Удаление заявок (находим заявку по id)
     *
     * Создаем три заявки и удаляем первую
     * Result должен быть true
     */
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        long created1 = System.currentTimeMillis();
        long created2 = System.currentTimeMillis();
        long created3 = System.currentTimeMillis();
        Item item1 = new Item("test1", "test1Description", created1);
        Item item2 = new Item("test2", "test2Description", created2);
        Item item3 = new Item("test3", "test3Description", created3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        boolean result = tracker.delete(item1.getId());
        assertThat((result), is(true));
    }

    /**
     * Test Replace application
     * Тест Редактирование (замена) заявки
     *
     * Создаем три заявки
     * Делаем замену: вторую заявку заменяем четвертой (входящей)
     * Ищем по getid второй заявки
     * Результат должен быть true
     */
    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        long created1 = System.currentTimeMillis();
        long created2 = System.currentTimeMillis();
        long created3 = System.currentTimeMillis();
        long created4 = System.currentTimeMillis();
        Item item1 = new Item("test1", "test1Description", created1);
        Item item2 = new Item("test2", "test2Description", created2);
        Item item3 = new Item("test3", "test3Description", created3);
        Item item4 = new Item("test4", "test4Description", created4);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        boolean result = tracker.replace(item2.getId(), item4);
        assertThat((result), is(true));
    }
}