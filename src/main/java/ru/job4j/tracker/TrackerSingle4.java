package ru.job4j.tracker;

/**
 * pattern Singleton. private static final class. Lazy loading.
 */
public class TrackerSingle4 {
    public Tracker tracker = new Tracker();

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

}
