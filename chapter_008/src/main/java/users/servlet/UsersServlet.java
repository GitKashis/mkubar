package users.servlet;

import users.User;
import users.UserStorage;

import javax.servlet.ServletException;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = new PrintWriter(response.getOutputStream());
        printWriter.append("<!DOCTYPE html>"
                + "<html lang=\"ru\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>"
                + "</head>"
                + "<body>"
                + "<p><b>Add new user</p>"
                + "<form action=\"/items/adduser\" method=\"post\">"
                + "Name : <input type='text' name='name'>"
                + "Login : <input type='text' name='login'>"
                + "email : <input type='email' name='email'>"
                + "<input type='submit'>"
                + "</form>"
                + getAllUser()
                + "</body>"
                + "</html>");
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        userStorage.addUserInDB(new User("name", req.getParameter("login"), req.getParameter("email"), "0000"));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }

    /**
     * Get all user in database http tag.
     * @return string
     */
    private String getAllUser() {
        StringBuilder builder = new StringBuilder();
        List<User> list = userStorage.getAllUserInDB();
        builder.append("<br>");
        builder.append("<p>Table all user</p>");
        builder.append("<table border=\"1\">");
        builder.append("<tr>"
                + "<th>ID</th>"
                + "<th>Login</th>"
                + "<th>Name</th>"
                + "<th>email</th>"
                + "<th>Create date</th>"
                + "<th>Delete User</th>"
                + "<th>Edit User</th>"
                + "</tr>");
        for (User next : list) {
            builder.append("<tr>");
            builder.append("<td>");
            builder.append(next.getId());
            builder.append("</td>");
            builder.append("<td>");
            builder.append(next.getLogin());
            builder.append("</td>");
            builder.append("<td>");
            builder.append(next.getName());
            builder.append("</td>");
            builder.append("<td>");
            builder.append(next.getEmail());
            builder.append("</td>");
            builder.append("<td>");
            builder.append(next.getCreateDate().getTime());
            builder.append("</td>");
            builder.append("<td align='center' valign='center'>"
                    + "<form action=\"/items/deluser\" method=\"post\">"
                    + "<input name='id' hidden value='"
                    + next.getId()
                    + "'/>"
                    + "<input type='submit' value='DELETE'/>"
                    + "</form>"
                    + "</td>");
            builder.append("<td align='center' valign='center'>"
                    + "<form action=\"/items/edituserform\" method=\"post\">"
                    + "<input name='id' hidden value='"
                    + next.getId()
                    + "'/>"
                    + "<input name='name' hidden value='"
                    + next.getName()
                    + "'/>"
                    + "<input name='login' hidden value='"
                    + next.getLogin()
                    + "'/>"
                    + "<input name='email' hidden value='"
                    + next.getEmail()
                    + "'/>"
                    + "<input type='submit' value='Edit'/>"
                    + "</form>"
                    + "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");
        return builder.toString();
    }
}


