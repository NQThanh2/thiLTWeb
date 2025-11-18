<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập</title></head>
<body>
    <h3>Đăng nhập</h3>
    <p style="color:red"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
    
    <form action="login" method="post">
        Tên đăng nhập: <input type="text" name="username" required /><br/><br/>
        Mật khẩu: <input type="password" name="password" required /><br/><br/>
        <input type="submit" value="Đăng nhập"/>
    </form>
</body>
</html>