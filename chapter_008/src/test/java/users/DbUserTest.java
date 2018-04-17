package users;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DbUserTest {

    @Test
    public void test() throws SQLException {
        DbUser db = new DbUser();
        db.addUserInDB(new User("mkubar", "kubar", "kubar@mail.ru", "root"));
    }

}