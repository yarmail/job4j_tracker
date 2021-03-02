package ru.job4j.tracker;

/**
 * pattern Singleton. Static final field. Eager loading.
 */
public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    public MemTracker tracker = new MemTracker();

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }
}
