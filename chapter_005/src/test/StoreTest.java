import org.junit.Before;
import org.junit.Test;
import ru.job4j.generic.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StoreTest {
    /**
     * Testing SimpleContainer element.
     */
    private AbstractStore<User> userStore;
    User user1, user2, user3;

    @Before
    public void setUp() {
        userStore = new UserStore();
        user1 = new User("1", "Ivan");
        user2 = new User("2", "Oleg");
    }

    @Test
    public void whenAddNewItemInUserStorageThenItAdded() {
        userStore.add(user1);
        User result = userStore.add(user2);
        assertThat(result, is(user2));
    }
    /**
     * Testing update element.
     */
    @Test
    public void whenUpdateItemInUserStorageThenItUpdated() {

        user1 = new User("1", "Ivan");
        user2 = new User("1", "Sergey");
        user3 = new User("2", "Sergey2");

        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);

        Base result = userStore.update(user2);
        assertThat(result, is(user1));
    }
    /**
     * Testing remove element.
     */
    @Test
    public void whenDeleteItemInUserStorageThenItDeleted() {
        AbstractStore<User> userStore = new UserStore();
        User user = new User("1", "Ivan");
        User user2 = new User("2", "Sergey");
        User user3 = new User("3", "Vasiliy");
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);

        boolean result = userStore.delete("2");

        User element = userStore.getStorage().get(1);
        String name = element.
                getName();

        assertThat(name, is("Vasiliy"));
    }
}
