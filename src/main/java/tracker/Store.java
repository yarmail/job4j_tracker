package tracker;

import java.util.List;

/**
 * Этот интерфейс наследуется от интерфейса AutoCloseable.
 * Нам нужно обеспечить закрытие ресурса.
 * Создадим класс SqlTracker.
 * Он будет расширять интерфейс Store.
 */
public interface Store extends AutoCloseable {

    void init();
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);
}
