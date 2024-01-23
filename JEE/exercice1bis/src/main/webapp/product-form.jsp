<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product formulaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2> Formulaire de création d'un produit </h2>
    <form action="produitForm" method="post">
        <div class="mb-3">
            <label for="brand" class="form-label">brand</label>
            <input type="text" class="form-control" id="brand" name="brand">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">price</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="index.jsp" class="btn btn-secondary">Menu</a>
    </form>
</div>
</body>
</html>
