<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="includes/head.jsp" />
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="includes/header.jsp" />
<div class="container">
    <h1>La liste des produits dont le prix est supérieur à 42€</h1>

    <table class="table text-center">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Brand</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${produits2}" var="produits">
            <tr class="text-center">
                <th scope="row">${produits.getIdProduct()}</th>
                <td>${produits.getBrand()}</td>
                <td>${produits.getPrice()}</td>
                <td><button type="button" class="btn btn-warning"> Details </button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
