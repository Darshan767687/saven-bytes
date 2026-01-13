<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Order Placed | SAVEN BYTES</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">

<style>
body {
    margin: 0;
    font-family: 'Inter', sans-serif;
    background: linear-gradient(180deg, #fff7f0, #ffffff);
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

/* ===== CARD ===== */
.card {
    background: #ffffff;
    width: 420px;
    padding: 42px 32px;
    border-radius: 22px;
    text-align: center;
    box-shadow: 0 14px 42px rgba(0,0,0,0.14);
    animation: slideUp 0.6s ease;
}

/* ===== SUCCESS ICON ===== */
.check {
    width: 96px;
    height: 96px;
    border-radius: 50%;
    background: #60b246;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: auto;
    animation: pop 0.45s ease;
}

.check img {
    width: 48px;
}

/* ===== TEXT ===== */
h1 {
    margin: 24px 0 10px;
    font-size: 1.9rem;
    color: #2f2f2f;
}

p {
    font-size: 0.95rem;
    color: #666;
    margin-bottom: 28px;
}

/* ===== BUTTON ===== */
.btn {
    padding: 14px 22px;
    background: #fc8019;
    color: #fff;
    border: none;
    border-radius: 12px;
    font-size: 1rem;
    font-weight: 700;
    cursor: pointer;
    transition: 0.2s ease;
    width: 100%;
}

.btn:hover {
    background: #e76f0f;
}

/* ===== FOOTER THANK YOU ===== */
.thanks {
    position: absolute;
    bottom: 36px;
    font-size: 0.9rem;
    color: #999;
    animation: fadeIn 1.2s ease;
}

/* ===== ANIMATIONS ===== */
@keyframes pop {
    from { transform: scale(0.6); opacity: 0; }
    to { transform: scale(1); opacity: 1; }
}

@keyframes slideUp {
    from { transform: translateY(40px); opacity: 0; }
    to { transform: translateY(0); opacity: 1; }
}

@keyframes fadeIn {
    from { opacity: 0; }
    to { opacity: 1; }
}
</style>
</head>

<body>

<div class="card">

    <!-- SUCCESS ICON -->
    <div class="check">
        <img src="https://cdn-icons-png.flaticon.com/512/845/845646.png" alt="Success">
    </div>

    <!-- TEXT -->
    <h1>Order Placed Successfully 🎉</h1>
    <p>Your food is being prepared. We’ll deliver it hot & fresh!</p>

    <!-- ACTION -->
    <button class="btn" onclick="orderMore()">Order More</button>
</div>

<div class="thanks">
    ❤️ Thank you for ordering from SAVEN BYTES
</div>

<script>
function orderMore() {
    window.location.href = "restdisp";
}
</script>

</body>
</html>
