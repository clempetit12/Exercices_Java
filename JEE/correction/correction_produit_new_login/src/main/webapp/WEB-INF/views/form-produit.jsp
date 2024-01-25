<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add produit</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
<c:if test="${produit == null}">
        <h2>Ajouter un produit </h2>
    </c:if>
        <c:if test="${produit != null}">
            <h2>Modifier un produit </h2>
        </c:if>
    </center>
    </center>
<div>
    <form action="insert" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <c:if test="${produit != null}">
                <input type="hidden" name="id" value="<c:out value='${produit.getId()}' />" />
            </c:if>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Marque</label>
                <input type="text" class="form-control" id="inputEmail4" name="marque" value="${produit.getMarque()}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Reference</label>
                <input type="text" class="form-control" id="inputPassword4" name="reference" value="${produit.getReference()}">
            </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputAddress">Prix</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="12" name="prix" value="${produit.getPrix()}">
        </div>
        <div class="form-group col-md-4">
            <label for="inputAddress2">Stock</label>
            <input type="text" class="form-control" id="inputAddress2" placeholder="50" name="stock" value="${produit.getStock()}">
        </div>
            <div class="form-group col-md-4">
                <label for="inputAddress3">Stock</label>
                <input type="date" class="form-control" id="inputAddress3" placeholder="50" name="dateAchat" value="${produit.getDateAchat()}">
            </div>
        </div>
        <div class="form-row">
        <div class="mb-3">
            <label for="formFile" class="form-label">Image</label>
            <input class="form-control" type="file" id="formFile" name="image" accept=".png" >
        </div>
        </div>
        <button type="submit" class="btn btn-primary">${produit == null ? 'Validation' : 'Update'}</button>
    </form>
</div>
</div>
</body>
</html>
