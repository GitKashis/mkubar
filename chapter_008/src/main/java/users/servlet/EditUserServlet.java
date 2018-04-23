package users.servlet;

import users.User;
import users.UserStorage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditUserServlet extends HttpServlet {
    /**
     * UserStorage object.
     */
    private UserStorage userStorage;

    {
        try {
            userStorage = UserStorage.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        userStorage.updateUserInDB(new User(id, name, login, email));
        resp.sendRedirect(String.format("%s/userstore", req.getContextPath()));
    }
}
