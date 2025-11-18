<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.Tour"%>
<!DOCTYPE html>
<html>
<head>
<title>Đặt Tour</title>
<style>
.row {
	margin-bottom: 10px;
}

label {
	display: inline-block;
	width: 150px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%
	Tour t = (Tour) request.getAttribute("tour");
	%>
	<h3>
		Đặt tour:
		<%=t != null ? t.getDescription() : ""%>
		-
		<%=t != null ? t.getDays() : ""%></h3>

	<form action="booking" method="post">
		<input type="hidden" name="tourId" value="${tour.id}" />

		<h4>Thông tin khách hàng</h4>
		<div class="row">
			<label>Họ tên: (*)</label> <input type="text" name="name" required />
		</div>
		<div class="row">
			<label>Địa chỉ:</label> <input type="text" name="address" />
		</div>
		<div class="row">
			<label>E-mail: (*)</label> <input type="email" name="email" required />
		</div>
		<div class="row">
			<label>Điện thoại:</label> <input type="text" name="phone" />
		</div>

		<h4>Thông tin chuyến đi</h4>
		<div class="row">
			<label>Ngày khởi hành: (*)</label> <input type="text"
				name="departureDate" placeholder="dd/mm/yyyy" required />
			(dd/mm/yyyy)
		</div>
		<div class="row">
			<label>Số người lớn: (*)</label> <input type="number" name="noAdults"
				required min="1" />
		</div>
		<div class="row">
			<label>Số trẻ em:</label> <input type="number" name="noChildren"
				value="0" />
		</div>

		<br/><a href="booking"><input type="submit" value="Gởi"/> </a> 
		<a href="list-tours"><input type="button" value="Hủy" /></a>
	</form>
</body>
</html>