package ru.job4j.tracker;

/**
 * pattern Singleton. Static field. Lazy loading.
 * Здесь главный момент это поле instance,
 * которое содержит экземпляр объекта и метод getInstance().
 * Метод getInstance() - при вызове метода, проверяет статическое поле instance,
 * если поле не загружено, оно инициализирует его новосозданном объектом.
 */
public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    public Tracker tracker = new Tracker();

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }
}