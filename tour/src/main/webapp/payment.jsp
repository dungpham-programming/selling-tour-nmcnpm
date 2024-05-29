<%@ page import="com.nmcnpm.model.OrderTour" %>
<%@ page import="com.nmcnpm.model.Transaction" %>
<%@ page import="java.util.UUID" %>
<%OrderTour orderTour = (OrderTour) request.getAttribute("orderTour");%>
<%
    int timer = (Integer) request.getAttribute("timer");
    System.out.println(timer);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Thanh Toán</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        .payment-methods {
            margin: 20px 0;
        }

        .qr-code {
            text-align: center;
            margin: 20px 0;
        }

        .amount {
            text-align: center;
            margin: 20px 0;
            font-size: 1.2em;
            font-weight: bold;
        }

        .timer {
            text-align: center;
            margin: 20px 0;
            font-size: 1.2em;
            color: red;
        }

        .fail-submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: orangered;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }

        .success-submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }

        .submit-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<% if (orderTour != null) { %>
<div class="container">
    <h1>Trang Thanh Toán</h1>
    <%if (orderTour.getPaymentTransactionId() != null) {%>
        <h1 style="color: #28a745">Đã thanh toán</h1>
    <%}else {%>
    <form action="<%=request.getContextPath()%>/payment" method="post">
        <input type="hidden" name="orderTourId" value="<%=orderTour.getId()%>">
        <h3>Chọn phương thức thanh toán:</h3>
        <div class="payment-methods">
            <label>
                <input type="radio" name="paymentMethod" value="Momo" checked>
                MOMO
            </label><br>
            <label>
                <input type="radio" name="paymentMethod" value="ZaloPay">
                ZaloPay
            </label><br>
            <label>
                <input type="radio" name="paymentMethod" value="VNPay">
                VNPay
            </label>
        </div>
        <div class="qr-code">
            <h3>Mã QR:</h3>
            <img src="https://via.placeholder.com/150" alt="QR Code">
        </div>
        <div class="amount">
            <input type="hidden" name="amount" value="<%=orderTour.getTotal()%>">
            <input type="hidden" name="currency" value="VND">
            Số tiền thanh toán: <span id="amount"><%=orderTour.getTotal()%> VND</span>
        </div>
        <div class="timer" id="timer">
            Thời gian còn lại: 05:00
        </div>
        <button type="submit" name="submit" value="fail" class="fail-submit-btn">Thanh Toán</button>
        <button type="submit" name="submit" value="success" class="success-submit-btn">Thanh Toán</button>
    </form>
    <%}%>
</div>
<% } else { %>
<h1>Dữ liệu không chính xác</h1>
<% } %>
<script>
    let timer = <%=timer%>
        function countdown() {
            if (timer > 0) {
                timer--;
                <%timer--;%>
                let minutes = parseInt(timer / 60, 10);
                let seconds = timer % 60;

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                document.getElementById("timer").innerHTML = "Thời gian còn lại: " + minutes + ":" + seconds;
                setTimeout(countdown, 1000);
            } else {
                <%timer = 0;%>
                document.getElementById("timer").innerHTML = "Phiên thanh toán đã hết!";
                document.querySelector('.submit-btn').disabled = true;
            }
        }

    window.onload = function () {
        countdown();
    };
</script>
</body>
</html>
