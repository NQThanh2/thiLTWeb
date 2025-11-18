package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.ForumService;
import java.io.IOException;

@WebServlet(name = "ReplyTopicServlet", urlPatterns = {"/reply-topic"})
public class ReplyTopicServlet extends HttpServlet {
    private ForumService service = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }
        req.setAttribute("topicId", req.getParameter("id"));
        req.setAttribute("topicTitle", req.getParameter("title"));
        req.getRequestDispatcher("replyTopic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            long topicId = Long.parseLong(req.getParameter("topicId"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            service.addReply(topicId, title, content, user);
            resp.sendRedirect("show-topic?id=" + topicId);
        } else {
            resp.sendRedirect("list-topics");
        }
    }
}