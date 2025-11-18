package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ForumService;
import model.Topic;
import java.io.IOException;

@WebServlet(name = "ShowTopicServlet", urlPatterns = {"/show-topic"})
public class ShowTopicServlet extends HttpServlet {
    private ForumService service = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            Topic t = service.getTopic(id);
            req.setAttribute("topic", t);
            req.getRequestDispatcher("showTopic.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendRedirect("list-topics");
        }
    }
}