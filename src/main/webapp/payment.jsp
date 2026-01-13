<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saven.model.Order" %>

<%
    List<Order> cart = (List<Order>) session.getAttribute("list");
    int total = 0;
    if (cart != null) {
        for (Order o : cart) {
            total += o.getPrice() * o.getQuantity();
        }
    }
    session.setAttribute("totalAmount", total);
%>

<!DOCTYPE html>
<html>
<head>
<title>Payment | SAVEN BYTES</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">

<style>
body {
    margin: 0;
    font-family: 'Inter', sans-serif;
    background: #f2f2f2;
}

/* ===== HEADER ===== */
.header {
    background: #fc8019;
    padding: 16px;
    color: white;
    font-size: 1.5rem;
    font-weight: 700;
}

/* ===== CONTAINER ===== */
.container {
    max-width: 900px;
    margin: 30px auto;
    display: grid;
    grid-template-columns: 1.2fr 0.8fr;
    gap: 24px;
}

/* ===== PAYMENT METHODS ===== */
.box {
    background: white;
    border-radius: 12px;
    padding: 20px;
    box-shadow: 0 6px 20px rgba(0,0,0,0.08);
}

.method {
    display: flex;
    align-items: center;
    gap: 14px;
    padding: 14px;
    border-radius: 10px;
    cursor: pointer;
    transition: 0.2s;
    border: 1px solid #eee;
    margin-bottom: 12px;
}

.method:hover {
    background: #fff4ec;
    border-color: #fc8019;
}

.method img {
    width: 36px;
}

.method.active {
    border: 2px solid #fc8019;
    background: #fff4ec;
}

/* ===== ORDER SUMMARY ===== */
.summary-item {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    font-size: 0.95rem;
}

.total {
    font-size: 1.2rem;
    font-weight: 700;
    margin-top: 14px;
}

/* ===== PAY BUTTON ===== */
.pay-btn {
    width: 100%;
    margin-top: 20px;
    padding: 14px;
    background: #60b246;
    border: none;
    color: white;
    font-size: 1.1rem;
    font-weight: 700;
    border-radius: 10px;
    cursor: pointer;
    transition: 0.2s;
}

.pay-btn:hover {
    background: #4fa03a;
}

/* ===== SUCCESS OVERLAY ===== */
.overlay {
    position: fixed;
    inset: 0;
    background: rgba(0,0,0,0.6);
    display: none;
    align-items: center;
    justify-content: center;
}

.success-box {
    background: white;
    padding: 40px;
    border-radius: 14px;
    text-align: center;
    animation: pop 0.4s ease;
}

@keyframes pop {
    from { transform: scale(0.7); opacity: 0; }
    to { transform: scale(1); opacity: 1; }
}

.success-box img {
    width: 80px;
    margin-bottom: 16px;
}
</style>
</head>

<body>

<div class="header">SAVEN BYTES • Payment</div>

<div class="container">

    <!-- LEFT: PAYMENT METHODS -->
    <div class="box">
        <h3>Select Payment Method</h3>

        <div class="method active">
            <img src="https://cdn-icons-png.flaticon.com/512/825/825454.png">
            UPI (GPay / PhonePe)
        </div>

        <div class="method">
            <img src="https://cdn-icons-png.flaticon.com/512/633/633611.png">
            Credit / Debit Card
        </div>

        <div class="method">
            <img src="https://cdn-icons-png.flaticon.com/512/1077/1077976.png">
            Cash on Delivery
        </div>
    </div>

    <!-- RIGHT: SUMMARY -->
    <div class="box">
        <h3>Order Summary</h3>

        <% if (cart != null) {
            for (Order o : cart) { %>
            <div class="summary-item">
                <span><%= o.getItemName() %> × <%= o.getQuantity() %></span>
                <span>₹ <%= o.getPrice() * o.getQuantity() %></span>
            </div>
        <% }} %>

        <hr>
        <div class="summary-item total">
            <span>Total</span>
            <span>₹ <%= total %></span>
        </div>

        <button class="pay-btn" onclick="payNow()">PAY ₹ <%= total %></button>
    </div>

</div>

<!-- SUCCESS -->
<div class="overlay" id="overlay">
    <div class="success-box">
        <img src="https://cdn-icons-png.flaticon.com/512/845/845646.png">
        <h2>Payment Successful 🎉</h2>
        <p>Your order is confirmed</p>
    </div>
</div>

<script>
function payNow() {
    document.getElementById("overlay").style.display = "flex";

    setTimeout(() => {
        window.location.href = "payment?action=placeOrder";
    }, 2000);
}
</script>

</body>
</html>
