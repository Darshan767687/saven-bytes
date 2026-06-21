<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saven.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<title>SAVEN BYTES | Order Food Online</title>

<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&family=Inter:wght@300;400;600;700&display=swap" rel="stylesheet">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

<style>
:root {
    --orange: #fc8019;
    --dark: #282c3f;
    --muted: #686b78;
}

* { box-sizing: border-box; }

body {
    margin: 0;
    font-family: 'Inter', sans-serif;
    background: #f8f8f8;
    color: var(--dark);
}

header {
    position: sticky;
    top: 0;
    z-index: 100;
    background: #fff;
    padding: 14px 36px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    box-shadow: 0 2px 14px rgba(0,0,0,0.08);
}

.logo {
    font-family: 'Montserrat', sans-serif;
    font-size: 1.6rem;
    font-weight: 700;
    color: var(--orange);
}

.tagline {
    font-size: 0.9rem;
    color: var(--muted);
}

.hero {
    background: linear-gradient(135deg, #fff3e6, #ffffff);
    padding: 40px 36px 26px;
}

.hero h1 {
    margin: 0;
    font-family: 'Montserrat', sans-serif;
    font-size: 2.2rem;
}

.hero p {
    margin-top: 6px;
    color: var(--muted);
}

.container {
    max-width: 1380px;
    margin: auto;
    padding: 22px 36px 50px;
}

.restaurant-list {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 26px;
}

@media (max-width: 1200px) { .restaurant-list { grid-template-columns: repeat(3, 1fr); } }
@media (max-width: 900px) { .restaurant-list { grid-template-columns: repeat(2, 1fr); } }
@media (max-width: 600px) { .restaurant-list { grid-template-columns: 1fr; } }

.card {
    background: #fff;
    border-radius: 16px;
    overflow: hidden;
    cursor: pointer;
    transition: transform .25s ease, box-shadow .25s ease;
}

.card:hover {
    transform: translateY(-6px);
    box-shadow: 0 14px 30px rgba(0,0,0,0.12);
}

.card img {
    width: 100%;
    height: 170px;
    object-fit: cover;
}

.fallback {
    height: 170px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #f2f2f2;
    color: #686b78;
    font-size: 14px;
}

.card-body {
    padding: 14px 16px 18px;
}

.name {
    font-size: 1.15rem;
    font-weight: 700;
    margin-bottom: 4px;
}

.meta {
    font-size: 0.88rem;
    color: var(--muted);
}

.rating {
    margin-top: 10px;
    display: inline-flex;
    align-items: center;
    gap: 6px;
    padding: 4px 8px;
    font-size: 0.85rem;
    font-weight: 700;
    color: #fff;
    border-radius: 6px;
}

.rating.high { background: #48c479; }
.rating.mid { background: #fa8c16; }
.rating.low { background: #e74c3c; }

a {
    text-decoration: none;
    color: inherit;
}
</style>
</head>

<body>

<header>
    <div class="logo">SAVEN BYTES</div>
    <div class="tagline">Delivering happiness 🍔</div>
</header>

<section class="hero">
    <h1 data-aos="fade-right">Restaurants near you</h1>
    <p data-aos="fade-right" data-aos-delay="120">
        Fresh food. Fast delivery. No compromises.
    </p>
</section>

<div class="container">
    <div class="restaurant-list">

<%
    List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurants");
    int delay = 0;

    if (list == null || list.isEmpty()) {
%>

        <div style="text-align:center; padding:50px; font-size:18px; color:#686b78;">
            🍽️ No restaurants found right now
        </div>

<%
    } else {

        for (Restaurant r : list) {
            delay += 70;

            double rating = r.getRating();
            String ratingClass = rating >= 4.5 ? "high" : rating >= 3.8 ? "mid" : "low";

            String img = r.getImagePath();
            boolean hasImage = (img != null && !img.trim().isEmpty());

            String finalImg = hasImage
                    ? request.getContextPath() + "/images/" + img.trim()
                    : null;

            System.out.println("🖼 IMAGE DEBUG -> " + img + " | FINAL -> " + finalImg);
%>

<a href="menu?restaurantId=<%= r.getRestaurantId() %>">
    <div class="card" data-aos="fade-up" data-aos-delay="<%=delay%>">

        <% if (hasImage) { %>

            <img src="<%= finalImg %>" 
                 onerror="this.style.display='none'; this.nextElementSibling.style.display='flex';" />

            <div class="fallback" style="display:none;">
                Image loading failed 🖼️
            </div>

        <% } else { %>

            <div class="fallback">
                No image available 🖼️
            </div>

        <% } %>

        <div class="card-body">
            <div class="name"><%= r.getName() %></div>
            <div class="meta"><%= r.getCuisineType() %></div>
            <div class="meta"><%= r.getAddress() %></div>

            <div class="rating <%=ratingClass%>">
                ⭐ <%= String.format("%.1f", rating) %>
            </div>
        </div>

    </div>
</a>

<%
        }
    }
%>

    </div>
</div>

<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
AOS.init({ duration: 700, once: true });
</script>

</body>
</html>