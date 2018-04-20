package users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    /**
     * UserStorage object.
     */
    private UserStorage userStorage;

    {
        try {
            userStorage = UserStorage.getInstance();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = new PrintWriter(response.getOutputStream());
        printWriter.append(getAllUser());
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean result = this.userStorage.addUserInDB(new User(name, login, email, password));
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append(result ? "true" : "false");
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        int iid = Integer.parseInt(req.getParameter("iid"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.userStorage.updateUserInDB(new User(iid, name, login, email));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        this.userStorage.delUserByEmail(email);
    }


    /**
     * Get all user in database http tag.
     * @return string
     */
    private String getAllUser() {
        StringBuilder builder = new StringBuilder();
        List<User> list = userStorage.getAllUserInDB();
        for (User next : list) {
            String fs = String.format("%-5s %-20s %-20s %-20s %-20s",
                    next.getId(),
                    next.getLogin(),
                    next.getName(),
                    next.getEmail(),
                    next.getCreateDate().getTime());
            builder.append(fs);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
