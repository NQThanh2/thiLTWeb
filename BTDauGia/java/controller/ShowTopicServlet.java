package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuctionService;
import java.io.IOException;

@WebServlet(name = "ShowTopicServlet", urlPatterns = {"/show-topic"})
public class ShowTopicServlet extends HttpServlet {
    private AuctionService service = new AuctionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }
        String idStr = req.getParameter("id");
        if (idStr != null) {
            req.setAttribute("item", service.getAuctionItem(Long.parseLong(idStr)));
            req.getRequestDispatcher("showTopic.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("list-items");
        }
    }
}