<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <title>Patients</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container p-3">
    <h1 class="text-center fs-1 mt-3 ">Liste Patients</h1>
    <hr>

    <div class="row">
        <c:forEach items="${patients}" var="patient">
            <div class="col-md-4 mb-4">
                <div class="card  " style="width: 18rem;">
                    <div class="text-center ">
                        <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getIdPatient()}"
                             class="img-thumbnail" style="width: 100px;height: 100px;" alt="Image du Patient"></td>
                    </div>

                    <div class="card-body">
                        <h5 class="card-title">Nom : ${patient.getLastName()}</h5>
                        <h6 class="card-title">Prénom : ${patient.getFirstName()}</h6>
                        <h6 class="card-title">Date de naissance : ${patient.getDateOfBirth()}</h6>
                        <div class="text-center">
                            <a type="button" href="delete?id=${patient.getIdPatient()}"
                               class="btn btn-danger">Delete</a>
                            <a type="button" href="details?id=${patient.getIdPatient()}"
                               class="btn btn-primary">Detail</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</div>

</html>
