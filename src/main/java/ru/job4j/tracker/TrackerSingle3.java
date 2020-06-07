package ru.job4j.tracker;

/**
 * pattern Singleton. Static final field. Eager loading.
 */
public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    public Tracker tracker = new Tracker();

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }
}
