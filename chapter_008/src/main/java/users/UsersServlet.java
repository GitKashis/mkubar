package users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {

    /**
     * UserStorage object.
     */
    private final UserStorage userStorage = UserStorage.getInstanse();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = new PrintWriter(response.getOutputStream());
        printWriter.append(getAllUser());
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean result = this.userStorage.addUserInDB(new User(name, login, email, password));
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append(result ? "true" : "false");
        printWriter.flush();
    }

    /**
     * Update
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int iid = Integer.parseInt(req.getParameter("iid"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.userStorage.updateUserInDB(new User(iid, name, login, email));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            builder.append(next.getId());
            builder.append(next.getLogin());
            builder.append(next.getName());
            builder.append(next.getEmail());
            builder.append(next.getCreateDate().getTime());
        }
        return builder.toString();
    }
}
