<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <jsp:include page="includes/head.jsp" />
</head>
<body>
<jsp:include page="includes/header.jsp" />

<h1 class="text-center">Patients</h1>
<a href="form" type="button">Add</a>

<c:forEach items="${patients}" var="patient">
    <div class="card" style="width: 18rem;">
        <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getIdPatient()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image du Patient"></td>
        <div class="card-body">
            <h5 class="card-title">Nom : ${patient.getLastName()}</h5>
            <h6 class="card-title">Prénom : ${patient.getFirstName()}</h6>
            <h6 class="card-title">Date de naissance : ${patient.getDateOfBirth()}</h6>
        </div>
    </div>



</c:forEach>
</body>
</html>
