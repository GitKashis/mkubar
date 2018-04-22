package users.servlet;

import users.UserStorage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
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
        this.userStorage.delUserByID(id);
        resp.sendRedirect("/items/userstore");
    }
}
