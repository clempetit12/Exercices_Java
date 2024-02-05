<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container p-3">
    <h1 class="text-center fs-1 mt-3 ">Liste des tâches</h1>
    <hr>

    <div class="row">
        <c:forEach items="${tasks}" var="task">
            <div class="col-md-4 mb-4">
                <div class="card  " style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Contenu : ${task.getContent()}</h5>
                        <button class="card-title" style="color: ${patient.status ? 'green' : 'red'};">
                            Status : ${patient.status ? 'Done' : 'À faire'}
                        </button>
                            <a type="button" href="delete?id=${patient.getIdPatient()}"
                               class="btn btn-danger">Delete</a>

                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
