<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--        import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
    <h1>Add new Product</h1>
        <form:form action="processUpdateProductForm" modelAttribute="productModel" method="post">
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="form-group">
                            <h3>Update Product</h3>
                        </div>
                        <div class="form-group">
                            <label for="name">Id</label>
                            <form:input type="text" cssClass="form-control" path="id" placeholder="${productModel.id}"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="name">product name</label>
                            <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="expirationDate">Expiration Date</label>
                            <form:input type="text" cssClass="form-control" path="expirationDate" placeholder="dd/mm/yyyy"/>
                            <form:errors path="expirationDate" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer">Manufacturer</label>
                            <form:input type="text" cssClass="form-control" path="manufacturer" placeholder="dd/mm/yyyy"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="text" cssClass="form-control" path="price" placeholder="dd/mm/yyyy"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="available">Availability</label>
                            <form:input type="text" cssClass="form-control" path="available" placeholder="dd/mm/yyyy"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>
                        <input type="submit" class="btn btn-primary"/>
                    </div>
                </div>
            </div>
        </form:form>
</body>

</html>