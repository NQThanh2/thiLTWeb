<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.AuctionItem" %>
<%@ page import="model.User" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách đấu giá</title>
    <style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 10px; width: 100%; }</style>
</head>
<body>
    <% User user = (User) session.getAttribute("user"); %>
    <div style="text-align: right">
        Chào mừng <%= user != null ? user.getUsername() : "" %> | <a href="logout">Thoát</a>
    </div>

    <h3>Danh mục các mặt hàng đấu giá</h3>
    <table>
        <tr>
            <th>Mặt hàng</th>
            <th>Giá</th>
        </tr>
        <%
            List<AuctionItem> items = (List<AuctionItem>) request.getAttribute("items");
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            if (items != null) {
                for (AuctionItem item : items) {
        %>
        <tr>
            <td>
                <a href="show-topic?id=<%= item.getId() %>">
                    <b><%= item.getDescription() %></b>
                </a>
            </td>
            <td>
                Giá khởi đầu: <%= nf.format(item.getInitialPrice()) %><br/>
                <% if (item.getBids().size() > 0) { %>
                    Giá hiện tại: <%= nf.format(item.getCurrentPrice()) %><br/>
                    (<%= item.getBids().size() %> lời đặt giá)
                <% } else { %>
                    (Chưa có đặt giá)
                <% } %>
            </td>
        </tr>
        <%      }
            } %>
    </table>
</body>
</html>