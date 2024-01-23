<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>


<h1>La liste des produits </h1>

<table class="table  m-4">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Brand</th>
        <th scope="col">Price</th>
        <th scope="col">Delete</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${produits}" var="produit">
        <tr>
            <td>${produit.getIdProduct()}</td>
            <td>${produit.getBrand()}</td>
            <td>${produit.getPrice()}</td>
            <td><button class="btn btn-secondary" onclick="deleteProduct(${produit.getIdProduct()})">Delete</button></td>
           <td><a href="produitDetail?id=${produit.getIdProduct()}"><button class="btn btn-warning" >Details</button></a></td>


        </tr>
    </c:forEach>
    </tbody>
    <a href="index.jsp" class="btn btn-secondary">Menu</a>
</table>


<script>
    function deleteProduct(id) {

        fetch('${pageContext.request.contextPath}/produit?id=' + id, {
            method: 'DELETE'
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erreur lors de la suppression du produit');
                }
                location.reload();
            })
            .catch(error => console.error(error));
    }
</script>


</body>
</html>
