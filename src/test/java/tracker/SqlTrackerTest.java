package tracker;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertEquals(result, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAddNewItemToTrackerThenItemHasSameId() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            String answer = item.getId();
            Item result = tracker.findById(answer);
            assertEquals(result.getId(), item.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAddNewItemTableSizeShouldIncrease() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            int expected = tracker.findAll().size() + 1;
            tracker.add(new Item("name"));
            assertThat(tracker.findAll().size(), is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindAllThenTrackerHas10Items() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Random rm = new Random();
            for (int index = 0; index < 10; index++) {
                tracker.add(new Item(String.valueOf(rm.nextLong())));
            }
            assertThat(tracker.findAll().size(), is(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplacedItemThenChangedName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("oldName"));
            String id = item.getId();
            Item expected = new Item("newName");
            tracker.replace(id, expected);
            assertEquals(tracker.findById(id).getName(), expected.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplacingItemSizeShouldNotChange() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = tracker.add(new Item("oldName")).getId();
            int expected = tracker.findAll().size();
            tracker.replace(id, new Item("newName"));
            int result = tracker.findAll().size();
            assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenItemDeletedSizeShouldDecrease() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = tracker.add(new Item("name")).getId();
            int expected = tracker.findAll().size() - 1;
            tracker.delete(id);
            int result = tracker.findAll().size();
            assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void whenDeleteItemThenNull() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name");
            tracker.add(item);
            String id = item.getId();
            tracker.delete(id);
            assertNull(tracker.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByNameQuantityMustMatch() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> items = new ArrayList<>();
            for (int index = 0; index < 10; index++) {
                items.add(tracker.add(new Item("name")));
            }
            assertThat(tracker.findByName("name").size(), is(items.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByIdNameAndIdMustMatche() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item expected = tracker.add(new Item("name"));
            String id = expected.getId();
            Item result = tracker.findById(id);
            assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}