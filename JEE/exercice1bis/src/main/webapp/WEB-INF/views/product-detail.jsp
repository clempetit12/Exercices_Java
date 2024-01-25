<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="container p-4">
    <h1>Détails produits</h1>
    <ul>
        <li>IdProduit : ${produit.getIdProduct()}</li>
        <li>Marque produit : ${produit.getBrand()}</li>
        <li>Prix produit : ${produit.getPrice()}</li>
    </ul>



</div>
<a href="../../index.jsp" class="btn btn-secondary ">Menu</a>
</body>
</html>
