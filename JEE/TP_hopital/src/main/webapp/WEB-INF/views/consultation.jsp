<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp" />

<h1 class="text-center">Détails Consultations</h1>
<h2 class="text-center">Prescriptions</h2>

<c:forEach items="${consultations.getPrescription()}" var="prescription">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Traitement : ${prescription.getMedication()}</h5>
            <h6 class="card-title">Durée : ${prescription.getDuration()}</h6>

        </div>
    </div>
</c:forEach>


<h2 class="text-center">Fiches de soins</h2>

<c:forEach items="${consultations.getCareFile()}" var="careFile">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Soin : ${careFile.getCare()}</h5>
            <h6 class="card-title">Durée : ${careFile.getDuration()}</h6>

        </div>
    </div>
</c:forEach>
</body>
</html>
