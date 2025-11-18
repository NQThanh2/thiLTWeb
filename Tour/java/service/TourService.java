package service;

import model.Booking;
import model.Customer;
import model.Tour;
import java.util.ArrayList;
import java.util.List;

public class TourService {
	private static List<Tour> tours = new ArrayList<>();

	static {
		tours.add(new Tour(1, "PHÚ QUỐC (Khuyến mãi mùa hè)", "3 ngày 2 đêm", "Máy bay", "Hằng ngày", 1595000,
				"<p><b>Ngày 01: ĐẾN PHÚ QUỐC : (máy bay)</b></br>"
						+ "Tham quan các điểm:  Làng chài Hàm Ninh. Tắm suối, leo núi tại Suối Tranh (theo mùa). "
						+ "Viếng chùa Sư Muôn. Tham tham quan thắng cảnh Dinh Cậu.</p>"
						+ "<p><b>Ngày 02: PHÚ QUỐC- SAY ĐẮM CÙNG THIÊN NHIÊN HOANG SƠ:</b></br>"
						+ "Tham quan các điểm: Nam Đảo. Cảng An Thới. Di tích nhà tù Phú Quốc. "
						+ "Cơ sở nuôi cấy ngọc trai. Tắm biển tại bãi Sao – nơi có bãi cát trắng dài và đẹp nhất Phú Quốc. "
						+ "Buổi chiều, đoàn sẽ tiếp tục tham quan: "
						+ "Tham quan Nhà thùng (cơ sở sản xuất nước mắm). Trại nuôi chó xoáy lưng Phú Quốc. "
						+ "Shop Cội Nguồn (cửa hàng bán hàng lưu niệm, đặc sản Phú Quốc). Viếng Sùng Hưng Tự. "
						+ "Ghé chợ Dương Đông</p>" + "<p><b>Ngày 03: TẠM BIỆT PHÚ QUỐC : ( máy bay )</b></p>"
						+ "Ăn sáng và tự do tắm biển. Sau khi ăn trưa, Quý khách làm thủ tục trả phòng. "
						+ "Xe sẽ đưa đoàn ra sân bay về Sài Gòn."));
		tours.add(new Tour(2, "NHA TRANG", "2 ngày 2 đêm", "Tàu hỏa", "Tối thứ 6 và CN", 1540000,
				"<p><b>Ngày 01 (Thứ bảy): PHỐ BIỂN NHA TRANG.</b></br>"
						+ "Tham quan suối Hoa Lan. Khám phá Mê Cung Trận Đồ. Chèo thuyền, ngắm cảnh trên Hồ Nghinh Xuân - Thủy Tiên."
						+ "KDL Hòn Lao - Đảo Khỉ. Tham gia chương trình giải trí tại Thế giới giải trí Vinpearl Land.</p>"
						+ "<p><b>Ngày 02 (Chủ nhật) : NHA TRANG – SÀI GÒN ( tàu lửa)</b></br>"
						+ "Tham quan Tháp Bà Ponagar. Chùa Long Sơn. Ngắm cảnh Hòn Chồng, núi Cô Tiên. Khu du lịch Suối Khoáng Nóng Tháp Bà."
						+ "Ăn tối, xe đưa quý khách ra ga Nha Trang khởi hành về Sài Gòn bằng tàu lửa. Kết thúc chuyến tham quan, hẹn ngày gặp lại."));
		tours.add(new Tour(3, "CÔN ĐẢO", "3 ngày 2 đêm", "Tàu", "Hằng ngày", 1345000, "Chi tiết Côn Đảo..."));
		tours.add(new Tour(4, "PHAN THIẾT MŨI NÉ", "2 ngày 1 đêm", "Xe khách", "Thứ 7 mỗi tuần", 1250000,
				"Chi tiết Phan Thiết..."));
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