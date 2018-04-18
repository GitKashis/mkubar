package users;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DbUserTest {

    @Test
    public void test() throws SQLException {
        DbUser db = DbUser.getInstanse();
        User user1 = new User("mkubar", "kubar", "kubar@mail.ru", "root");
        db.addUserInDB(user1);
        User user2 = new User("QWERTY", "kubar", "kubar@mail.ru", "root");
        user1.setPassword("QWERTY");
        db.updateUserInDB(user1);
       // db.addUserInDB(user2);
       // db.delUserByEmail("kubar@mail.ru");
        db.getAllUserInDB().forEach(System.out::println);

    }

}