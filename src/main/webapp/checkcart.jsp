<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saven.model.Order" %>

<%
    List<Order> cart = (List<Order>) session.getAttribute("list");
    int grandTotal = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart | SAVEN BYTES</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&family=Inter:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
            background: #f2f2f2;
            padding-bottom: 100px;
        }

        header {
            background: #fff;
            padding: 16px;
            font-size: 1.4rem;
            font-weight: 700;
            color: #282c3f;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
            position: sticky;
            top: 0;
            z-index: 10;
        }

        .cart-container {
            max-width: 900px;
            margin: 20px auto;
            padding: 0 16px;
        }

        .cart-card {
            background: #fff;
            border-radius: 12px;
            padding: 18px;
            box-shadow: 0 4px 16px rgba(0,0,0,0.08);
        }

        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 14px 0;
            border-bottom: 1px solid #eee;
            animation: fadeUp 0.4s ease;
        }

        .cart-item:last-child {
            border-bottom: none;
        }

        .item-name {
            font-size: 1.05rem;
            font-weight: 600;
            color: #282c3f;
        }

        .price {
            font-weight: 700;
        }

        /* ===== QUANTITY ===== */
        .qty-box {
            display: flex;
            align-items: center;
            border: 1px solid #fc8019;
            border-radius: 6px;
            overflow: hidden;
        }

        .qty-btn {
            padding: 6px 12px;
            background: #fff;
            color: #fc8019;
            font-size: 1.2rem;
            font-weight: 700;
            border: none;
            cursor: pointer;
        }

        .qty-btn:hover {
            background: #fff3e6;
        }

        .qty-value {
            padding: 6px 14px;
            font-weight: 700;
            background: #fc8019;
            color: #fff;
        }

        /* ===== BOTTOM BAR ===== */
        .order-bar {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            background: #fff;
            box-shadow: 0 -4px 14px rgba(0,0,0,0.15);
            padding: 14px 18px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            animation: slideUp 0.4s ease;
        }

        .total-text {
            font-size: 0.85rem;
            color: #686b78;
        }

        .total-amount {
            font-size: 1.4rem;
            font-weight: 700;
        }

        .order-btn {
            padding: 14px 28px;
            background: #fc8019;
            color: #fff;
            font-weight: 700;
            border-radius: 10px;
            text-decoration: none;
            font-size: 1rem;
        }

        @keyframes fadeUp {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        @keyframes slideUp {
            from { transform: translateY(100%); }
            to { transform: translateY(0); }
        }
    </style>

    <script>
        function updateCart(menuId, action) {
            fetch("cart", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: "menuId=" + menuId + "&action=" + action
            }).then(() => {
                location.reload();
            });
        }
    </script>
</head>

<body>

<header>Your Cart</header>

<div class="cart-container">
    <div class="cart-card">

<%
    if (cart == null || cart.isEmpty()) {
%>
        <p style="text-align:center; padding:40px;">🛒 Your cart is empty</p>
<%
    } else {
        for (Order o : cart) {
            int total = o.getPrice() * o.getQuantity();
            grandTotal += total;
%>
        <div class="cart-item">
            <div>
                <div class="item-name"><%= o.getItemName() %></div>
                <div class="price">₹ <%= total %></div>
            </div>

            <div class="qty-box">
                <button class="qty-btn"
                        onclick="updateCart(<%= o.getMenuId() %>, 'remove')">−</button>
                <div class="qty-value"><%= o.getQuantity() %></div>
                <button class="qty-btn"
                        onclick="updateCart(<%= o.getMenuId() %>, 'add')">+</button>
            </div>
        </div>
<%
        }
    }
%>

    </div>
</div>

<% if (cart != null && !cart.isEmpty()) { %>
<div class="order-bar">
    <div>
        <div class="total-text">TO PAY</div>
        <div class="total-amount">₹ <%= grandTotal %></div>
    </div>

    <a href="payment.jsp" class="order-btn">PLACE ORDER</a>
</div>
<% } %>

</body>
</html>
