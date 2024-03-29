<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product formulaire</title>
    <jsp:include page="../includes/head.jsp"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container">


    </form>
   <h2>"${produit == null ? 'Création' : 'Edition'}"</h2> enctype="multipart/form-data" >
        <input type="hidden" id="id" name="id" value="${produit != null ? produit.getIdProduct() : ''}">
        <div class="mb-3">
            <label for="brand" class="form-label">brand</label>
            <input type="text" class="form-control" id="brand" name="brand" value="${ produit != null ? produit.getBrand() : " "}">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">price</label>
            <input type="text" class="form-control" id="price" name="price" value="${ produit != null ? produit.getPrice() : " "}">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

    </form>



</div>
</body>
</html>
