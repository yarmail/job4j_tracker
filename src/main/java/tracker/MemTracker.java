package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemTracker {
    /**
     * Массив для хранения заявок
     */
    private final List<Item> items = new ArrayList<>(0);

    /**
     * Generating a unique key based on the current time and a random number
     * Генерируем уникальный ключ на основе текущего времени и случайного числа
     * <p>
     * Если генерация ключа нужна не чаще раза в секунду можно использовать:
     * 1) currentTimeMillis() (~13 знаков)
     * 2) Math.random (~ 4 знака)
     * 3) привести к общему типу long и сложить
     * 4) перевести в  String (в условиях данной задачи)
     *
     * Нужно проверить:
     * Возможная проблема может заключаться в том, что диапазон
     * значений Math.random() может быть от [0, 1) и продумать,
     * что будет при 0. Возможно следует добавить маленькую величину
     */
    private String generateId() {
        long unixTime = System.currentTimeMillis();
        long rnd = (long) Math.random() * 10000L;
        String result = Long.toString(unixTime + rnd);
        return result;
    }

    /**
     * Аdd method adds ids and adds new order to storage
     * Метод добавляет id и добавляет новую заявку в хранилище
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return this.items;
    }

    private int indexOf(String id) {
        return Stream
                .iterate(0, i -> i + 1)
                .filter(i -> i < items.size())
                .filter(i -> items.get(i).getId().equals(id))
                .findFirst()
                .orElse(-1);
    }

    public Item findById(String id) {
        Item result = null;
        int i = indexOf(id);
        if (i > -1) {
            result = items.get(i);
        }
        return result;
    }
    /* другая версия
    public Item findById(String id) {
        Item result = null;
        if (!this.items.isEmpty()) {
            result = this.items.stream()
                    .filter(item -> item.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }
        return result;
    }
    */

    public List<Item> findByName(String key) {
        return this.items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
        }

    public boolean delete(String id) {
        boolean result = false;
        int i = indexOf(id);
        if (i > -1) {
            items.remove(i);
            result = true;
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int i = indexOf(id);
        if (i > -1) {
            items.set(i, item);
            item.setId(id);
            result = true;
        }
        return result;
    }
}