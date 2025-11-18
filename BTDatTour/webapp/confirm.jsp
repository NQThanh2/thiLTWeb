<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Booking" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head><title>Xác nhận</title></head>
<body>
    <h2 style="color: blue">Đặt Tour Thành Công!</h2>
    <p>Cảm ơn quý khách đã đặt tour. Dưới đây là thông tin xác nhận:</p>
    
    <%
        Booking b = (Booking) request.getAttribute("booking");
        if (b != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    %>
    <ul>
        <li><b>Tour:</b> <%= b.getTour().getDescription() %></li>
        <li><b>Họ tên khách hàng:</b> <%= b.getCustomer().getName() %></li>
        <li><b>Email:</b> <%= b.getCustomer().getEmail() %></li>
        <li><b>Ngày khởi hành:</b> <%= sdf.format(b.getDepartureDate()) %></li>
        <li><b>Số người lớn:</b> <%= b.getNoAdults() %></li>
        <li><b>Số trẻ em:</b> <%= b.getNoChildren() %></li>
    </ul>
    <% } %>
    
    <a href="tour?action=list">Quay về Trang chủ</a>
</body>
</html>