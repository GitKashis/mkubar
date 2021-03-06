package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.item.Bug;
import ru.job4j.tracker.item.Item;
import ru.job4j.tracker.item.Task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerDBTest {
    /**
     * Object for need check.
     */
    private TrackerDB trackerDB;

    /**
     * Initialize fro test.
     */
    @Before
    public void initialize() throws IOException, ClassNotFoundException, SQLException {
        this.trackerDB = new TrackerDB();
    }

    /**
     * Test add item.
     */
    @Test
    public void whenAddItemInDbThenAddInDb() throws SQLException, ClassNotFoundException, IOException {
        Item item = new Task("testJUnit", "testJUnit");
        int execute = trackerDB.addItem(item);
        assertThat(execute, is(1));
    }

    /**
     * Test get all item in DB.
     */
    @Test
    public void whenNeedGetAllItemsThenGet() throws SQLException, ClassNotFoundException, IOException {
        Item item = new Bug("testJUnit", "testJUnit");
        trackerDB.addItem(item);
        Map<Integer, Item> result = trackerDB.findAll();
        assertThat(result.size() > 0, is(true));
    }

    /**
     * Test find by name in DB.
     */
    @Test
    public void whenNeedFindItemByNameThenFound() throws SQLException, ClassNotFoundException, IOException {
        Item item = new Bug("testJUnit", "testJUnit");
        trackerDB.addItem(item);
        Map<Integer, Item> result = trackerDB.findByName("testJUnit");
        int iid = -1;
        for (Map.Entry<Integer, Item> next : result.entrySet()) {
            iid = Integer.parseInt(next.getValue().getId());
        }
        assertThat(result.get(iid).getName(), is(item.getName()));
        trackerDB.deleteItemById(iid);
    }

    /**
     * Test find by name.
     */
    @Test
    public void whenNeedFindByNameThenFound() throws SQLException, ClassNotFoundException, IOException {
        Item item = new Bug("testJUnit", "testJUnit");
        trackerDB.addItem(item);
        Item result = trackerDB.findById(Integer.valueOf(item.getId()));
        assertThat(result.getId(), is(item.getId()));
        trackerDB.deleteItemById(Integer.valueOf(result.getId()));
    }
}