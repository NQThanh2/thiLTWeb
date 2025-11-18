<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Tour" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Tour</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Các Chương trình DU LỊCH</h2>
    <table>
        <tr>
            <th>Chương trình</th>
            <th>Lịch Khởi hành</th>
            <th>Giá</th>
            <th>Đặt</th>
        </tr>
        <%
            // Lấy list từ Controller, ép kiểu thủ công vì không dùng JSTL
            List<Tour> tours = (List<Tour>) request.getAttribute("tours");
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            
            if (tours != null) {
                for (Tour t : tours) {
        %>
        <tr>
            <td>
                <a href="tour?action=details&id=<%= t.getId() %>">
                    <b><%= t.getDescription() %></b>
                </a>
                <br/>
                <%= t.getDays() %>
            </td>
            <td><%= t.getDepartureSchedule() %></td>
            <td><%= nf.format(t.getPrice()) %></td>
            <td>
                <a href="tour?action=book&id=<%= t.getId() %>">Đặt tour</a>
            </td>
        </tr>
        <% 
                } 
            } 
        %>
    </table>
</body>
</html>tran