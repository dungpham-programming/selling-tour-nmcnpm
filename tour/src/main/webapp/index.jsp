<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>Chọn thanh toán!</h2>
<form action="<%=request.getContextPath()%>/payment">
    <input type="hidden" name="orderTourId" value="1">
    <button type="submit">Tiến hành thanh toán</button>
</form>
</body>
</html>
