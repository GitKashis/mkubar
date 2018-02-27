package ru.job4j.thread.nonblocking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CacheTest {

    /**
     * Field for create new object for test.
     */
    private Cache<User> cache = new Cache<>();

    /**
     * Test add new User.
     */
    @Test
    public void whenAddUserInCacheThenAdd() {
        boolean test = cache.add(new User("qwerty", 123));
        boolean test1 = cache.add(new User("qwerty", 123));

        assertThat(test, is(true));
        assertThat(test1, is(false));
    }

    /**
     * Test delete user of the cache.
     */
    @Test
    public void whenDeleteUserThenDel() {
        User user = new User("qwerty", 123);
        cache.add(user);

        assertThat(cache.delete(user), is(true));
    }

    /**
     * Test update user.
     */
    @Test
    public void whenUpdateUserThenUpdate() {
        User user = new User("qwerty", 123);
        cache.add(user);
        user.setName("Zzzed");

        assertThat(cache.update(user), is(true));
    }
}