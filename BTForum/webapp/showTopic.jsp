<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Stack" %>
<!DOCTYPE html>
<html>
<head><title>Chi tiết chủ đề</title></head>
<body>
    <% 
        User user = (User) session.getAttribute("user"); 
        Topic t = (Topic) request.getAttribute("topic");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
    %>
    <div style="text-align:right">
        <% if(user != null) { %>
            Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
        <% } %>
    </div>

    <% if (t != null) { %>
        <h3>Chủ đề: <%= t.getTitle() %></h3>
        <p>Bài mới nhất: <%= sdf.format(t.getCreatedTime()) %> do <%= t.getCreator().getUserName() %> gửi. <%= t.getMessages().size() %> hồi âm.</p>

        <table border="1" width="100%">
            <tr style="background:#ddd">
                <td width="20%"><%= sdf.format(t.getCreatedTime()) %><br/><b><%= t.getCreator().getUserName() %></b></td>
                <td>
                    <b><%= t.getTitle() %></b><br/>
                    <p><%= t.getContent() %></p>
                    <% if(user != null) { %>
                        <div style="text-align:right">
                            <a href="reply-topic?id=<%= t.getId() %>&title=<%= t.getTitle() %>">[ Trả lời ]</a>
                        </div>
                    <% } %>
                </td>
            </tr>
            
            <% 
                Stack<Message> msgs = t.getMessages();
                // Stack duyệt từ trên xuống dưới, nếu muốn hiện cũ nhất trước thì dùng for thường
                for(int i = 0; i < msgs.size(); i++) {
                    Message m = msgs.get(i);
            %>
            <tr>
                <td><%= sdf.format(m.getCreatedTime()) %><br/><b><%= m.getCreator().getUserName() %></b></td>
                <td>
                    <b><%= m.getTitle() %></b><br/>
                    <p><%= m.getContent() %></p>
                </td>
            </tr>
            <% } %>
        </table>
        
        <br/>
        <a href="list-topics">Danh sách chủ đề</a>
    <% } else { %>
        <p>Chủ đề không tồn tại.</p>
        <a href="list-topics">Quay lại</a>
    <% } %>
</body>
</html>