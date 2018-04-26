package users.servlet;

import users.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SigninServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/LoginView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        System.out.println(login);
        String password = req.getParameter("password");
        if (userStorage.isCredentional(login, password)) {
            HttpSession session = req.getSession();
                session.setAttribute("login", login);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid");
            doGet(req, resp);
        }
    }
}
