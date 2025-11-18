<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<html>
<head><title>Trả lời</title></head>
<body>
    <% 
        User user = (User) session.getAttribute("user"); 
        String topicId = (String) request.getAttribute("topicId");
        String topicTitle = (String) request.getAttribute("topicTitle");
    %>
    <div style="text-align:right">Chào <%= user.getUserName() %> | <a href="logout">Thoát</a></div>

    <h3>Trả lời</h3>
    <form action="reply-topic" method="post">
        <input type="hidden" name="topicId" value="<%= topicId %>"/>
        
        Tiêu đề:<br/> 
        <input type="text" name="title" value="Re: <%= topicTitle %>" style="width:400px"/><br/><br/>
        
        Nội dung:<br/> 
        <textarea name="content" rows="10" cols="50" required></textarea><br/><br/>
        
        <input type="submit" value="Gởi"/>
        <a href="list-topics"><input type="button" value="Hủy bỏ"/></a>
    </form>
</body>
</html>