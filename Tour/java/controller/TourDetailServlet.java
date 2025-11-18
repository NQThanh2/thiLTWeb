package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tour;
import service.TourService;

/**
 * Servlet implementation class TourDetailServlet
 */
@WebServlet("/tour-details")
public class TourDetailServlet extends HttpServlet {
	private TourService tourService = new TourService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		if(id1 != null) {
			Long id = Long.parseLong(id1);
			Tour tour = tourService.getTour(id);
			request.setAttribute("tour", tour);
			request.getRequestDispatcher("tourDetails.jsp").forward(request, response);
		}else {
			response.sendRedirect("list-tours");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
