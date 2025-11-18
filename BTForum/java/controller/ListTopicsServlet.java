package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ForumService;
import java.io.IOException;

@WebServlet(name = "ListTopicsServlet", urlPatterns = {"/list-topics", ""})
public class ListTopicsServlet extends HttpServlet {
    private ForumService service = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("topics", service.getTopics());
        req.getRequestDispatcher("listTopics.jsp").forward(req, resp);
    }
}