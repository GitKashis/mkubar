package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for testing user.
 **/
public class UserTest {
    /**
     * Testing addition same objects into map.
     */
    @Test
    public void whenAddUsersWithoutHashCodeAndEqualsShouldAddBoth() {
        Map<User, Object> map = new HashMap<>();

        User user1 = new User("Test", 0, new GregorianCalendar(1980, 3, 12));
        User user2 = new User("Test", 0, new GregorianCalendar(1980, 3, 12));

        map.put(user1, new Object());
        map.put(user2, new Object());

        map.forEach((user, o) -> System.out.println(user.toString()));

        System.out.println(map);
        System.out.println(map.size());
    }

}