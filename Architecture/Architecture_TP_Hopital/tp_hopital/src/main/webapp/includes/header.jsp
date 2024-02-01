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
    <a class="navbar-brand" href="#"><i class="bi bi-calendar-plus"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="listPatients">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="form">Add</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="listPatients">List</a>
            </li>
        </ul>

        <div class="form-inline my-2 my-lg-0 ">
            <form action="search" method="get" class="form-inline">
                <div class="input-group mb-2 mx-sm-3">
                    <label for="lastName" class="sr-only">LastName</label>
                    <input type="text" class="form-control" id="lastName" placeholder="LastName" name="lastName">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-primary">
                            <i class="bi bi-search-heart-fill"></i> Search
                        </button>
                    </div>
                    <a class="btn btn-outline-danger my-2 my-sm-0 ml-3" href="user">Login</a>
                </div>
            </form>
        </div>
    </div>
</nav>

</body>
</html>
