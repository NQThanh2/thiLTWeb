<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Tour"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tour</title>
<style >
 table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; font-size: 14px; }
        th { background-color: #e0e0e0; text-align: center; font-weight: bold; }
</style>
</head>
<body>
	<h2>Các Chương Trình Du Lịch</h2>
	<table>
		<tr>
			<th>Chương trình</th>
			<th>Lịch Khởi hành</th>
			<th>Giá</th>
			<th>Đặt</th>
		</tr>
		<%
		List<Tour> tours = (List<Tour>) request.getAttribute("tours");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

		if (tours != null) {
			for (Tour t : tours) {
		%>
		<tr>
			<td><a href="tour-details?id=<%=t.getId()%>"> <b><%=t.getDescription()%></b>
			</a> <br /> <%=t.getDays()%></td>
			<td><%=t.getDepartureSchedule()%></td>
			<td><%=nf.format(t.getPrice())%></td>
			<td><a href="booking?id=<%= t.getId() %>">Đặt tour</a>
			</td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>