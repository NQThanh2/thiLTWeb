package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.ForumService;
import java.io.IOException;

@WebServlet(name = "NewTopicServlet", urlPatterns = {"/new-topic"})
public class NewTopicServlet extends HttpServlet {
    private ForumService service = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login");
        } else {
            req.getRequestDispatcher("newTopic.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            service.addNewTopic(title, content, user);
        }
        resp.sendRedirect("list-topics");
    }
}