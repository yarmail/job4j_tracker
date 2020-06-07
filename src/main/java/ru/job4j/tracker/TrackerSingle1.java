package ru.job4j.tracker;

/**
 * pattern Singleton. Enum. Eager loading.
 * Create only 1 object Tracker with enum
 */
public enum TrackerSingle1 {
    INSTANCE;
    public Tracker tracker = new Tracker();
}
