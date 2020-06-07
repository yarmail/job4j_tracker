package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerSingleTest {

    /**
     * pattern Singleton. Enum. Eager loading.
     * Create only 1 object Tracker with enum
     */
    @Test
    public void test1() {
        TrackerSingle1 first = TrackerSingle1.INSTANCE;
        TrackerSingle1 second = TrackerSingle1.INSTANCE;
        assertThat(first, is(second));
    }

    /**
     * pattern Singleton. Static field. Lazy loading.
     * Здесь главный момент это поле instance,
     * которое содержит экземпляр объекта и метод getInstance().
     * Метод getInstance() - при вызове метода, проверяет статическое поле instance,
     * если поле не загружено, оно инициализирует его новосозданном объектом.
     *
     */
    @Test
    public void test2() {
        TrackerSingle2 first = TrackerSingle2.getInstance();
        TrackerSingle2 second = TrackerSingle2.getInstance();
        assertThat(first, is(second));
    }

    /**
     * pattern Singleton. Static final field. Eager loading.
     */
    @Test
    public void test3() {
        TrackerSingle3 first = TrackerSingle3.getInstance();
        TrackerSingle3 second = TrackerSingle3.getInstance();
        assertThat(first, is(second));
    }

    /**
     * pattern Singleton. private static final class. Lazy loading.
     */
    @Test
    public void test4() {
        TrackerSingle4 first = TrackerSingle4.getInstance();
        TrackerSingle4 second = TrackerSingle4.getInstance();
        assertThat(first, is(second));
    }
}
