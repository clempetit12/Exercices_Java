
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <jsp:include page="head.jsp" />
    <title></title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="list">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="new">Add</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://www.amazon.fr/" >Amazon</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">About</a>
            </li>
        </ul>



        <div class="form-inline  gx-4 my-lg-0 text-center ">
            <form action="search" method="get" class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <label for="lastName" class="sr-only">LastName</label>
                    <input type="lastName" class="form-control" id="lastName" placeholder="lastName" name="lastName">
                </div>
                <button type="submit" class="btn btn-primary mb-2"><i class="bi bi-search-heart-fill"></i></button>
                <a class="btn btn-outline-danger my-2 my-sm-0" href="user">Logout</a>
            </form>

        </div>
    </div>
</nav>
</body>
</html>
