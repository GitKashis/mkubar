package users;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserStorageTest {
    @Test
    public void test() throws SQLException {
        UserStorage userStorage = UserStorage.getInstance();
        userStorage.createTableInDB();
    }

}