<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.AuctionItem" %>
<%@ page import="model.User" %>
<%@ page import="model.Bid" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head><title>Chi tiết mặt hàng</title></head>
<body>
    <% 
        User user = (User) session.getAttribute("user"); 
        AuctionItem item = (AuctionItem) request.getAttribute("item");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    %>
    <div style="text-align: right">
        Chào <%= user.getUsername() %> | <a href="logout">Thoát</a>
    </div>

    <% if (item != null) { %>
        <h3 style="color: blue"><%= item.getDescription() %></h3>
        <table border="1" style="width: 100%">
            <tr>
                <td width="60%" valign="top">
                    Giá hiện tại: <b><%= nf.format(item.getCurrentPrice()) %></b><br/><br/>
                    
                    <% 
                        // Hiển thị người đặt cao nhất (người cuối cùng trong list bid)
                        String topBidder = "Chưa có";
                        int bidCount = item.getBids().size();
                        if (bidCount > 0) {
                            topBidder = item.getBids().get(bidCount - 1).getBidder().getUsername();
                        }
                    %>
                    Người đặt: <%= topBidder %> (có <%= bidCount %> đặt giá)<br/><br/>
                    Giá khởi điểm: <%= nf.format(item.getInitialPrice()) %><br/><br/>
                    Bước giá: <%= nf.format(item.getPriceStep()) %>
                </td>
                <td valign="top">
                    <b>Thông tin người bán</b><br/>
                    Tên tài khoản: <%= item.getSeller().getUsername() %><br/>
                    Tên cửa hàng: <%= item.getSeller().getCompanyName() %><br/>
                    Điện thoại: <%= item.getSeller().getPhone() %><br/>
                    Email: <%= item.getSeller().getEmail() %><br/>
                    Địa chỉ: <%= item.getSeller().getAddress() %>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    Bắt đầu lúc: <%= sdf.format(item.getStartDate()) %><br/>
                    Kết thúc lúc: <%= sdf.format(item.getEndDate()) %><br/>
                    Thời gian còn: <span style="color: red"><%= item.getDuration() %></span>
                </td>
            </tr>
        </table>

        <br/>
        <form action="bid" method="post">
            <input type="hidden" name="itemId" value="<%= item.getId() %>"/>
            <% 
                double minPrice = item.getCurrentPrice() + item.getPriceStep(); 
            %>
            <b>Giá đặt:</b> >= <%= nf.format(minPrice) %> <br/>
            <input type="number" name="amount" value="<%= (long)minPrice %>" />
            <input type="submit" value="Đặt giá"/>
        </form>
        
        <br/>
        <a href="list-items">Danh sách đấu giá</a>
    <% } else { %>
        <p>Sản phẩm không tồn tại.</p>
        <a href="list-items">Quay lại</a>
    <% } %>
</body>
</html>