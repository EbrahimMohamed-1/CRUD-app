<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .product-card {
            max-width: 600px;
            margin: auto;
            background: white;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        .product-title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        .product-detail {
            font-size: 18px;
            margin: 10px 0;
        }
        .badge {
            font-size: 1rem;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="product-card shadow-lg p-4">
        <h2 class="product-title text-center text-primary">${productDetailsView.name}</h2>
        <hr>
        <div class="product-detail"><strong>Expiration Date:</strong> ${productDetailsView.expirationDate}</div>
        <div class="product-detail"><strong>Manufacturer:</strong> ${productDetailsView.manufacturer}</div>
        <div class="product-detail"><strong>Price:</strong> $${productDetailsView.price}</div>
        <div class="product-detail"><strong>Availability:</strong>
            <span class="badge ${productDetailsView.available ? 'bg-success' : 'bg-danger'}">
                ${productDetailsView.available ? 'Available' : 'Out of Stock'}
            </span>
        </div>

    </div>
</div>
</body>
</html>
