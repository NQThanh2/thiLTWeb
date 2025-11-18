<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Tour" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông Tin Chuyến Đi</title>
</head>
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
        <a href="booking?id=<%= t.getId() %>">[ Đặt tour ]</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list-tours">[ CHƯƠNG TRÌNH TOUR ]</a>
    <%
        } else {
            out.print("Không tìm thấy thông tin tour.");
        }
    %>
</body>
</html>