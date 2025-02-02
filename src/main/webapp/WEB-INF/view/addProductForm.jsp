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
        <form:form action="processAddProduct" modelAttribute="productDetailsModel">
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="form-group">
                            <h3>Add Product</h3>
                        </div>
                        <div class="form-group">
                            <label for="name">product name</label>
                            <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="expirationDate">Expiration Date</label>
                            <form:input type="date" cssClass="form-control" path="expirationDate" placeholder="dd/mm/yyyy"/>
                            <form:errors path="expirationDate" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer">Manufacturer</label>
                            <form:input type="text" cssClass="form-control" path="manufacturer" placeholder="Manufacturer"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="number" cssClass="form-control"  step= "0.1" path="price" placeholder="Price"/>
                            <form:errors path="price" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="available">Availability</label>
                            <form:input type="text" cssClass="form-control" path="available" placeholder="0 or 1"/>
                            <form:errors path="available" cssClass="error"/>
                        </div>
<%--                        <div class="form-group">--%>

<%--                            <form:input type="file"  enctype="multipart/form-data" name="img" path="img" class="form-control" />--%>
<%--                        </div>--%>
                        <input type="submit" class="btn btn-primary"/>
                    </div>
                </div>
            </div>
        </form:form>
</body>

</html>