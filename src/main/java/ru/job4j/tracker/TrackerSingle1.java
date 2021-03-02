package ru.job4j.tracker;

/**
 * pattern Singleton. Enum. Eager loading.
 * Create only 1 object Tracker with enum
 */
public enum TrackerSingle1 {
    INSTANCE;
    public MemTracker tracker = new MemTracker();
}
