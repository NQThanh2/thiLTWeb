package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AuctionItem;
import model.User;
import service.AuctionService;
import java.io.IOException;

@WebServlet(name = "BidServlet", urlPatterns = {"/bid"})
public class BidServlet extends HttpServlet {
    private AuctionService service = new AuctionService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }

        try {
            long itemId = Long.parseLong(req.getParameter("itemId"));
            double amount = Double.parseDouble(req.getParameter("amount"));
            AuctionItem item = service.getAuctionItem(itemId);

            // Kiểm tra giá hợp lệ [cite: 133]
            double minValidPrice = item.getCurrentPrice() + item.getPriceStep();
            
            if (amount >= minValidPrice) {
                service.bid(user, item, amount); // Cập nhật giá
                resp.sendRedirect("list-items"); // Chuyển về trang list
            } else {
                // Nếu lỗi thì quay lại trang chi tiết và báo lỗi (đơn giản thì quay lại list)
                resp.sendRedirect("show-topic?id=" + itemId + "&error=invalid_price");
            }
        } catch (Exception e) {
            resp.sendRedirect("list-items");
        }
    }
}