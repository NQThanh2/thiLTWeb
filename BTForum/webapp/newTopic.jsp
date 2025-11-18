<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<html>
<head><title>Gởi bài mới</title></head>
<body>
    <% User user = (User) session.getAttribute("user"); %>
    <div style="text-align:right">Chào <%= user.getUserName() %> | <a href="logout">Thoát</a></div>

    <h3>Gởi bài mới</h3>
    <form action="new-topic" method="post">
        Tiêu đề:<br/> <input type="text" name="title" style="width:400px" required/><br/><br/>
        Nội dung:<br/> <textarea name="content" rows="10" cols="50" required></textarea><br/><br/>
        
        <input type="submit" value="Gởi"/>
        <a href="list-topics"><input type="button" value="Hủy bỏ"/></a>
    </form>
</body>
</html>