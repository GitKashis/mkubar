package users;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void isCredentional() throws SQLException {
        UserStorage userStorage = UserStorage.getInstance();
    boolean result = userStorage.isCredentional("kubar", "kubar");
        System.out.println(result);
    }
}