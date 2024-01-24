<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <div class="p-4">
  <title >Produits</title>
    <jsp:include page="includes/head.jsp" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>



<body>

<jsp:include page="includes/header.jsp" />
<h1 class="text-center"><%= "Produits" %></h1>
<div class="d-grid gap-2 col-2 mx-auto mt-4">
  <a  href="protected" class="btn btn-info" type="button "> <i class="bi bi-patch-plus-fill"></i>  Authentification</a>
</div>
<%
  String user = (String) session.getAttribute("user");

  if (user != null && !user.isEmpty()) {
%>

<form action="LogoutServlet" method="post">
  <div class="d-grid gap-2 d-md-flex justify-content-md-end p-4">
  <input type="submit" class="btn btn-success btn-sm" value="Déconnexion">
  </div>
</form>



<br/>
<ul class="list-group p-2" >
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produit" class="btn ">Produits</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produitPrice" class="btn ">Produits par prix</a>

  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <a href="produitDate" class="btn ">Produits par date</a>

  </li>






</ul>
<%
  }
%>


</body>
</div>
</html>