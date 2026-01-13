<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saven.model.Menu" %>
<%@ page import="com.saven.model.Restaurant" %>

<%
    Restaurant restaurant = (Restaurant) request.getAttribute("restaurant");
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
%>

<!DOCTYPE html>
<html>
<head>
<title><%= restaurant.getName() %> | Menu</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">

<style>
body {
    margin: 0;
    font-family: 'Inter', sans-serif;
    background: #f2f2f2;
}

/* HEADER */
header {
    background: white;
    padding: 16px;
    text-align: center;
    font-size: 1.6rem;
    font-weight: 700;
    color: #fc8019;
    border-bottom: 1px solid #eee;
}

/* RESTAURANT BANNER */
.hero {
    background: linear-gradient(135deg, #fc8019, #ff9f4a);
    color: white;
    padding: 30px;
}

.hero h1 {
    margin: 0;
    font-size: 2rem;
}

.hero .meta {
    margin-top: 6px;
    font-size: 0.95rem;
}

.rating {
    display: inline-block;
    background: #48c479;
    padding: 5px 10px;
    border-radius: 6px;
    margin-top: 10px;
    font-weight: 700;
}

/* MENU */
.menu-wrapper {
    max-width: 900px;
    margin: 24px auto;
    padding: 0 16px;
}

.menu-card {
    display: flex;
    gap: 16px;
    background: white;
    border-radius: 14px;
    padding: 14px;
    margin-bottom: 16px;
    box-shadow: 0 4px 14px rgba(0,0,0,0.08);
}

.menu-card img {
    width: 120px;
    height: 120px;
    border-radius: 10px;
    object-fit: cover;
}

.menu-info {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.menu-name {
    font-size: 1.15rem;
    font-weight: 700;
}

.menu-desc {
    font-size: 0.9rem;
    color: #666;
    margin: 6px 0;
}

.menu-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.price {
    font-size: 1.05rem;
    font-weight: 700;
}

.add-btn {
    border: 2px solid #60b246;
    background: white;
    color: #60b246;
    padding: 6px 16px;
    border-radius: 8px;
    font-weight: 700;
    cursor: pointer;
    transition: 0.2s;
}

.add-btn:hover {
    background: #60b246;
    color: white;
}

/* CART BUTTON */
.cart-btn {
    position: fixed;
    bottom: 20px;
    right: 20px;
    background: #fc8019;
    color: white;
    padding: 14px 20px;
    border-radius: 50px;
    font-weight: 700;
    text-decoration: none;
    box-shadow: 0 6px 20px rgba(0,0,0,0.25);
}

/* TOAST */
.toast {
    position: fixed;
    bottom: 90px;
    left: 50%;
    transform: translateX(-50%) translateY(20px);
    background: #323232;
    color: white;
    padding: 12px 20px;
    border-radius: 30px;
    opacity: 0;
    transition: 0.3s;
    z-index: 999;
}

.toast.show {
    opacity: 1;
    transform: translateX(-50%) translateY(0);
}
</style>
</head>

<body>

<header>SAVEN BYTES</header>

<div class="hero">
    <h1><%= restaurant.getName() %></h1>
    <div class="meta"><%= restaurant.getAddress() %></div>
    <div class="rating">⭐ <%= restaurant.getRating() %></div>
</div>

<div class="menu-wrapper">

<%
String[] images = {
    "https://cdn-icons-png.flaticon.com/512/1046/1046784.png",
    "https://cdn-icons-png.flaticon.com/512/135/135763.png",
    "https://cdn-icons-png.flaticon.com/512/2921/2921822.png",
    "https://cdn-icons-png.flaticon.com/512/3480/3480618.png"
};

for (Menu m : menuList) {
    String img = images[m.getMenuId() % images.length];
%>

<div class="menu-card">
    <img src="<%= img %>" alt="food">

    <div class="menu-info">
        <div>
            <div class="menu-name"><%= m.getItemName() %></div>
            <div class="menu-desc"><%= m.getDescription() %></div>
        </div>

        <div class="menu-footer">
            <div class="price">₹ <%= m.getPrice() %></div>
            <button class="add-btn"
                onclick="addToCart('<%= m.getMenuId() %>',
                                   '<%= restaurant.getRestaurantId() %>',
                                   '<%= m.getItemName() %>',
                                   '<%= m.getPrice() %>')">
                ADD
            </button>
        </div>
    </div>
</div>

<% } %>

</div>

<a href="cart" class="cart-btn">🛒 View Cart</a>

<div id="toast" class="toast"></div>

<script>
function addToCart(menuId, restaurantId, itemName, price) {
    fetch("cart", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body:
            "menuId=" + menuId +
            "&restaurantId=" + restaurantId +
            "&itemName=" + encodeURIComponent(itemName) +
            "&price=" + price
    });

    showToast(itemName + " added to cart");
}

function showToast(msg) {
    const toast = document.getElementById("toast");
    toast.innerText = "✔ " + msg;
    toast.classList.add("show");
    setTimeout(() => toast.classList.remove("show"), 2000);
}
</script>

</body>
</html>
