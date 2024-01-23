<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Produits</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1><%= "Produits!" %></h1>
<br/>
<ul class="list-group p-2" >
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produit">Produits</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produitPrice">Produits par prix</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produitDate">Produits par date</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produitForm">Formulaire création produit</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="user">Formulaire création user</a>

  </li>

  <a class="btn btn-warning" type="button " href="protected">Authentification</a>



</ul>


</body>
</html>