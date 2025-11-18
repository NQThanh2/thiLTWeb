package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuctionService;
import java.io.IOException;

@WebServlet(name = "ListItemsServlet", urlPatterns = {"/list-items"})
public class ListItemsServlet extends HttpServlet {
    private AuctionService service = new AuctionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Kiểm tra đăng nhập
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }
        req.setAttribute("items", service.getAllAuctionItems());
        req.getRequestDispatcher("listItems.jsp").forward(req, resp);
    }
}