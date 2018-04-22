package users.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        int id = Integer.valueOf(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        printWriter.append("<!DOCTYPE html>"
                + "<html lang=\"ru\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>"
                + "</head>"
                + "<body>"
                + "<p><b>Edit user:  "
                + name
                + "</p>"
                + "<form action=\"/items/edituser\" method=\"post\">"
                + "<input type='text' name='id' hidden value='"
                + id
                + "'>"
                + "Name : <input type='text' name='name' value='"
                + name
                + "'>"
                + "Login : <input type='text' name='login' value='"
                + login
                + "'>"
                + "email : <input type='email' name='email' value='"
                + email
                + "'>"
                + "<input type='submit'>"
                + "</form>"
                + "</body>"
                + "</html>");
        printWriter.flush();
    }
}
