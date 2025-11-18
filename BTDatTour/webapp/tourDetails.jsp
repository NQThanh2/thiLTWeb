<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Tour" %>
<!DOCTYPE html>
<html>
<head><title>Chi tiết Tour</title></head>
<body>
    <%
        Tour t = (Tour) request.getAttribute("tour");
        if (t != null) {
    %>
        <h2 style="color: #b22222"><%= t.getDescription() %></h2>
        <p>
            <b>Số ngày:</b> <%= t.getDays() %>. 
            <b>Phương tiện:</b> <%= t.getTransportation() %>. 
            <b>Lịch khởi hành:</b> <%= t.getDepartureSchedule() %>
        </p>
        
        <h3>Chương trình chi tiết:</h3>
        <div style="border: 1px dotted gray; padding: 10px; width: 80%">
            <%= t.getDetails() %>
        </div>
        
        <br/>
        <hr/>
        <a href="tour?action=book&id=<%= t.getId() %>">[ Đặt tour ]</a>
        &nbsp;&nbsp;&nbsp;
        <a href="tour?action=list">[ CHƯƠNG TRÌNH TOUR ]</a>
    <%
        } else {
            out.print("Không tìm thấy thông tin tour.");
        }
    %>
</body>
</html>