package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Booking;
import model.Customer;
import model.Tour;
import service.TourService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// URL patterns xử lý cho toàn bộ các câu hỏi
@WebServlet(name = "TourServlet", urlPatterns = {"/tour", "/listTours", "/tourDetails", "/bookingTour"})
public class TourServlet extends HttpServlet {
    
    private TourService tourService = new TourService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                showListTours(req, resp);
                break;
            case "details": // Câu 2
                showTourDetails(req, resp);
                break;
            case "book": // Câu 3 (Form đặt tour)
                showBookingForm(req, resp);
                break;
            default:
                showListTours(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý submit form ở câu 3
        String action = req.getParameter("action");
        if ("save".equals(action)) {
            processBooking(req, resp);
        }
    }

    // --- CÁC HÀM XỬ LÝ ---

    private void showListTours(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy dữ liệu đưa vào request attribute để JSP hiển thị
        req.setAttribute("tours", tourService.getAllTours());
        req.getRequestDispatcher("listTours.jsp").forward(req, resp);
    }

    private void showTourDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("tour", tourService.getTour(id));
        req.getRequestDispatcher("tourDetails.jsp").forward(req, resp);
    }

    private void showBookingForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("tour", tourService.getTour(id));
        req.getRequestDispatcher("bookingTour.jsp").forward(req, resp);
    }

    private void processBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. Nhận tham số
            Long tourId = Long.parseLong(req.getParameter("tourId"));
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String dateStr = req.getParameter("departureDate");
            int noAdults = Integer.parseInt(req.getParameter("noAdults"));
            int noChildren = 0;
            try { noChildren = Integer.parseInt(req.getParameter("noChildren")); } catch(Exception e){}

            // 2. Tạo đối tượng
            Customer cust = new Customer();
            cust.setName(name); cust.setAddress(address); cust.setEmail(email); cust.setPhone(phone);
            
            Booking booking = new Booking();
            booking.setCustomer(cust);
            booking.setTour(tourService.getTour(tourId));
            booking.setNoAdults(noAdults);
            booking.setNoChildren(noChildren);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            booking.setDepartureDate(sdf.parse(dateStr));

            // 3. Lưu (Giả lập)
            tourService.saveCustomer(cust);
            tourService.saveBooking(booking);

            // 4. Chuyển trang xác nhận
            req.setAttribute("booking", booking);
            req.getRequestDispatcher("confirm.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Lỗi định dạng dữ liệu: " + e.getMessage());
        }
    }
}