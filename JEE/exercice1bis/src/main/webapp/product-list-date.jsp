<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits entre deux dates</title>
</head>
<body>
<h1>La liste des produits </h1>

<c:forEach items="${produits3}" var="produit">
    <div>
        idProduct : ${produit.getIdProduct()}
        brand : ${produit.getBrand()}
        price : ${produit.getPrice()}
    </div>


</c:forEach>
</body>
</html>
