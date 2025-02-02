<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%-- Bootstrap CSS --%>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">

    <%-- Custom Styles --%>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }

        .container {
            max-width: 1400px;
            margin-top: 50px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 28px;
            font-weight: bold;
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }

        .table {
            border-radius: 5px;
            overflow: hidden;
            background: white;
            font-size: large;
        }

        .table thead {
            background-color: #343a40;
            color: white;
        }

        .btn {
            font-size: 16px;
            padding: 5px 10px;
        }

        .btn-primary {
            background-color: #007bff;
        }

        .btn-warning {
            background-color: #ffc107;
        }

        .btn-danger {
            background-color: #dc3545;
        }

        .btn-success {
            background-color: #28a745;
        }

        .btn-container {
            text-align: center;
            margin-top: 20px;
        }

    </style>
</head>

<body>

<div class="container">
    <h1>Products Data</h1>

    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Show Details</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>
                    <form:form action="viewDetailsPage/${item.id}" method="get">
                        <button type="submit" class="btn btn-primary btn-sm">View Details</button>
                    </form:form>
                </td>
                <td>
                    <form:form action="updateDetails/${item.id}" method="get">
                        <button type="submit" class="btn btn-warning btn-sm">Update</button>
                    </form:form>
                </td>
                <td>
                    <form:form action="deleteProduct/${item.id}" method="get">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="btn-container">
        <form:form action="addProduct" method="get">
            <button type="submit" class="btn btn-success btn-lg">Add New Product</button>
        </form:form>
    </div>
</div>

</body>
</html>
