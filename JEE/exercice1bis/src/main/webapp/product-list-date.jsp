<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="includes/head.jsp" />
    <title>Produits entre deux dates</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="includes/header.jsp" />
<h1>La liste des produits entre deux dates </h1>

<table class=" table m-4">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Brand</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${produits3}" var="produit">
    <tr >


        <td class="text-center">  ${produit.getIdProduct()}</td>
        <td class="text-center">   ${produit.getBrand()}</td>
        <td class="text-center">   ${produit.getPrice()}</td>
    </tr>







</c:forEach>
    </tbody>
</table>
</body>
</html>
