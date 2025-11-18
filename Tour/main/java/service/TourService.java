package service;

import model.Booking;
import model.Customer;
import model.Tour;
import java.util.ArrayList;
import java.util.List;

public class TourService {
    private static List<Tour> tours = new ArrayList<>();
 
    static {
        tours.add(new Tour(1, "PHÚ QUỐC (Khuyến mãi mùa hè)", "3 ngày 2 đêm", "Máy bay", "Hằng ngày", 1595000, "Chi tiết Phú Quốc..."));
        tours.add(new Tour(2, "NHA TRANG", "2 ngày 2 đêm", "Tàu hỏa", "Tối thứ 6 và CN", 1540000, "Tham quan Tháp Bà Ponagar, Vinpearl Land..."));
        tours.add(new Tour(3, "CÔN ĐẢO", "3 ngày 2 đêm", "Tàu", "Hằng ngày", 1345000, "Chi tiết Côn Đảo..."));
        tours.add(new Tour(4, "PHAN THIẾT MŨI NÉ", "2 ngày 1 đêm", "Xe khách", "Thứ 7 mỗi tuần", 1250000, "Chi tiết Phan Thiết..."));
    }

    public List<Tour> getAllTours() {
        return tours;
    }

    public Tour getTour(Long id) {
        for (Tour t : tours) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void saveCustomer(Customer customer) {
        System.out.println("Saved Customer: " + customer.getName());
    }

    public void saveBooking(Booking booking) {
        System.out.println("Saved Booking for tour: " + booking.getTour().getDescription());
    }
}