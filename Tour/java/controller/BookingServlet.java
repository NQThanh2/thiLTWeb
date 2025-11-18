package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.Customer;
import service.TourService;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
	private TourService tourService = new TourService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id1 = request.getParameter("id");
		if (id1 != null) {
			Long id = Long.parseLong(id1);
			request.setAttribute("tour", tourService.getTour(id));
			request.getRequestDispatcher("bookingTour.jsp").forward(request, response);
		} else {
			response.sendRedirect("/list-tours");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			Long tourId = Long.parseLong(request.getParameter("tourId"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String dateStr = request.getParameter("departureDate");
			int noAdults = Integer.parseInt(request.getParameter("noAdults"));
			int noChildren = 0;
			try {
				noChildren = Integer.parseInt(request.getParameter("noChildren"));
			} catch (Exception e) {
			}

			Customer cus = new Customer();
			cus.setName(name);
			cus.setAddress(address);
			cus.setEmail(email);
			cus.setPhone(phone);

			Booking booking = new Booking();
			booking.setCustomer(cus);
			booking.setTour(tourService.getTour(tourId));
			booking.setNoAdults(noAdults);
			booking.setNoChildren(noChildren);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			booking.setDepartureDate(sdf.parse(dateStr));

			tourService.saveCustomer(cus);
			tourService.saveBooking(booking);

			request.setAttribute("booking", booking);
			request.getRequestDispatcher("confirm.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
