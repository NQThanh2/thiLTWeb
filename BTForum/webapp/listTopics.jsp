<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách chủ đề</title>
    <style>table{width:100%; border-collapse: collapse;} th,td{border:1px solid #ccc; padding:5px;}</style>
</head>
<body>
    <% User user = (User) session.getAttribute("user"); %>
    <div style="text-align:right">
        <% if(user != null) { %>
            Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
        <% } else { %>
            <a href="login">Đăng nhập</a>
        <% } %>
    </div>

    <h3>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ học tập</h3>

    <% if(user != null) { %>
        <a href="new-topic"><button>Gởi bài mới</button></a><br/><br/>
    <% } %>

    <table>
        <tr style="background:#eee">
            <th>Chủ đề</th>
            <th>Bài mới nhất</th>
            <th>Hồi âm</th>
        </tr>
        <%
            List<Topic> topics = (List<Topic>) request.getAttribute("topics");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
            if (topics != null) {
                for(Topic t : topics) {
                    Message lastMsg = t.getNewMessage();
        %>
        <tr>
            <td>
                <a href="show-topic?id=<%= t.getId() %>"><b><%= t.getTitle() %></b></a>
            </td>
            <td>
                <% if (lastMsg != null) { %>
                    by <%= lastMsg.getCreator().getUserName() %>, <%= sdf.format(lastMsg.getCreatedTime()) %>
                <% } else { %>
                    by <%= t.getCreator().getUserName() %>, <%= sdf.format(t.getCreatedTime()) %>
                <% } %>
            </td>
            <td style="text-align:center"><%= t.getMessages().size() %></td>
        </tr>
        <%      }
            } %>
    </table>
</body>
</html>