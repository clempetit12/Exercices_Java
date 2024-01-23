
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>La liste des produits dont le prix est supérieur à 42€ </h1>

<c:forEach items="${produits2}" var="produits">
    <div>
        idProduct : ${produits.getIdProduct()}
        brand : ${produits.getBrand()}
        price : ${produits.getPrice()}
    </div>


</c:forEach>

</body>
</html>
