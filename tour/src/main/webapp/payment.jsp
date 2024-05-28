<%@ page import="com.nmcnpm.model.OrderTour" %>
<%OrderTour orderTour = (OrderTour) request.getAttribute("orderTour");%>
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
        .submit-btn {
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
    <% if(orderTour != null) { %>
<div class="container">
    <h1>Trang Thanh Toán</h1>

    <h3>Chọn phương thức thanh toán:</h3>
    <div class="payment-methods">
        <label>
            <input type="radio" name="payment-method" value="credit-card" checked>
            MOMO
        </label><br>
        <label>
            <input type="radio" name="payment-method" value="bank-transfer">
            ZaloPay
        </label><br>
        <label>
            <input type="radio" name="payment-method" value="e-wallet">
            VNPay
        </label>
    </div>

    <div class="qr-code">
        <h3>Mã QR:</h3>
        <img src="https://via.placeholder.com/150" alt="QR Code">
    </div>

    <div class="amount">
        Số tiền thanh toán: <span id="amount"><%=orderTour.getTotal()%> VND</span>
    </div>

    <div class="timer" id="timer">
        Thời gian còn lại: 05:00
    </div>

    <button class="submit-btn">Thanh Toán</button>
</div>
    <% } else { %>
<h1>Dữ liệu không chính xác</h1>
    <% } %>
    <script>
        let timer = 5 * 60;

        function countdown() {
            if (timer > 0) {
                timer--;
                let minutes = parseInt(timer / 60, 10);
                let seconds = timer % 60;

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                document.getElementById("timer").innerHTML = "Thời gian còn lại: " + minutes + ":" + seconds;
                setTimeout(countdown, 1000);
            } else {
                document.getElementById("timer").innerHTML = "Phiên thanh toán đã hết!";
                document.querySelector('.submit-btn').disabled = true;
            }
        }

        window.onload = function() {
            countdown();
        };
    </script>
</body>
</html>
