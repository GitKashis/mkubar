package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class testing tracker app.
 *
 * @author gkuznetsov.
 * @since 21.12.17.
 * @version 0.1.
 */
public class StartUITest {
    /**
     * Test addition item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "User 1", "description for user 1", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("User 1"));
    }

    /**
     * Test updating item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description", "Comment"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "New User", "New Description", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("New User"));
    }
    /**
     * Testing deleting item.
     */
    @Test
    public void whenUserDeleteItemThenItemDeleteFromTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description", "Comment"));
        tracker.add(new Item("User-2", "Description2", "Comment"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("User-2"));
    }

    /**
     * Test searching item by ID.
     */
    @Test
    public void whenUserSearchItemByIDThenReturnItemWithSameID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description", "Comment"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getId(), is(id));
    }

    /**
     * Test searching items by name.
     */
    @Test
    public void whenUserSearchItemByNameThenReturnItemsSameWithNames() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("User-121", "Description", "Comment"));
        tracker.add(new Item("User-122", "Description", "Comment"));
        tracker.add(new Item("User-121", "Description", "Comment"));
        tracker.add(new Item("User-123", "Description", "Comment"));
        Input input = new StubInput(new String[]{"5", "User-121", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("User-121").getName(), is("User-121"));
    }

    /**
     * Test exit.
     */
    @Test
    public void whenUserExit() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("User-121", "Description", "Comment"));
        tracker.add(new Item("User-122", "Description", "Comment"));
        tracker.add(new Item("User-121", "Description", "Comment"));
        tracker.add(new Item("User-123", "Description", "Comment"));
        Input input = new StubInput(new String[]{"6", "y"});
        new StartUI(input, tracker).init();
       // assertThat(tracker.findByName("User-121").getName(), is("User-121"));
    }

}