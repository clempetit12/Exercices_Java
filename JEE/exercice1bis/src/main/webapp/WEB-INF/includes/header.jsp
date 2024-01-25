<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title></title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#"><i class="bi bi-house"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="new">Add</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="user"><i class="bi bi-person-plus-fill"></i></a>
            </li>
        </ul>
    </div>
    <form action="LogoutServlet" method="post" class="ml-auto"> <!-- Added ml-auto class for margin-left: auto -->
        <div class="d-grid gap-2 d-md-flex justify-content-md-end p-4">
            <input type="submit" class="btn btn-success btn-sm" value="Déconnexion">
        </div>
    </form>
</nav>
</body>
</html>
