package users.servlet;

import users.User;
import users.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UsersController extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        synchronized (session) {
            if (session == null || session.getAttribute("login") == null) {
                response.sendRedirect(String.format("%s/signin", request.getContextPath()));
            } else {
                request.setAttribute("users", userStorage.getAllUserInDB());
                request.getRequestDispatcher("/WEB-INF/view/UserOrder.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        userStorage.addUserInDB(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), "0000"));
        resp.sendRedirect(req.getContextPath());
    }
}


