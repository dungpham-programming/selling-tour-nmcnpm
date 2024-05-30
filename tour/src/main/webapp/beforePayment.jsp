<%@ page import="com.nmcnpm.payment.model.OrderTour" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nmcnpm.payment.dao.OrderTourDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<OrderTour> orderTours = OrderTourDAO.getOrderTourToPayment();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .container{
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            overflow: auto;
            z-index: 9;
            background-color: #2c3e50; /* Adjust the background color as needed */
            padding: 20px;
            color: white;
            font-size: larger;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Chọn thanh toán!</h2>
    <form action="<%=request.getContextPath()%>/to-payment-page" method="post">
        <div style="display: flex">
            <h4>Order Tour Id chưa thanh toán </h4>
            <select name="orderTourId" id="orderTourId">
                <%
                    if (!orderTours.isEmpty()) {
                        for (OrderTour o : orderTours) {
                %>
                <option value="<%=o.getId()%>"><%=o.getId()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <button type="submit" style="width: 100%;">Tiến hành thanh toán</button>
    </form>
</div>
</body>
</html>
