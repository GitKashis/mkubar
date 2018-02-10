package ru.job4j.storage;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    /**
     * User storage test.
     */
    @Test
    public void test() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 250);
        User user2 = new User(2, 200);
        User user3 = new User(3, 0);

        Thread t1 = new Thread(() -> {
            storage.add(new User(4, 440));
            storage.add(user1);
            storage.add(user2);
            storage.transfer(user1.getId(), user2.getId(), 100);
        });

        Thread t2 = new Thread(() -> {
            storage.add(user3);
            storage.transfer(user1.getId(), user3.getId(), 100);
        });

        t1.start();
        t2.start();

        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(storage.getUser(1).getAmount());
        System.out.println(storage.getUser(2).getAmount());
        System.out.println(storage.getUser(3).getAmount());
        System.out.println(storage.getStorageSize());

        assertThat(50, is(storage.getUser(1).getAmount()));
    }
}