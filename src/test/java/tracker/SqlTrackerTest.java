package tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Если мы запустим этот тест два раза он у нас упадет.
 * Потому, что в базе будет созданы две записи.
 * Чтобы избежать такой ситуации в JDBC можно использовать
 * метод откатывания изменения - rollback.
 *
 * Этот метод, может работать только с режиме autocommit = false.
 * То есть все изменения сначала содержаться в памяти до момента,
 * когда мы не выполним commit();
 *
 * Так же autocommit = false - позволяет увеличить скорость работы тестов,
 * так как мы не сохраняем данные на диске, а только делаем изменения в памяти.
 */
public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void add() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Item1"));
            assertThat(tracker.findByName("Item1").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void replace() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Item1"));
            String id = item.getId();
            tracker.replace(id, new Item("Item2"));
            assertThat(tracker.findByName("Item2").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Item1"));
            String id = item.getId();
            tracker.delete(id);
            assertNull(tracker.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            int sum = tracker.findAll().size();
            tracker.add(new Item("Item1"));
            assertEquals(sum + 1, tracker.findAll().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Item1"));
            assertEquals(tracker.findByName(item.getName()), List.of(item));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Item1"));
            String id = item.getId();
            assertEquals(tracker.findById(id), item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
