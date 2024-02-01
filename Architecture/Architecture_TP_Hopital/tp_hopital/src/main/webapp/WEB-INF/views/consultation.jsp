<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <jsp:include page="../../includes/head.jsp"/>
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>

<h1 class="text-center">Détails Consultations</h1>
<hr>
<h2 class="text-center">Prescriptions</h2>
<hr>

<div class="container p-3 ">
    <div class="row justify-content-center text-center mb-4">
        <c:forEach items="${consultation.getPrescription()}" var="prescription">
            <div class="card bg-primary" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Traitement : ${prescription.getMedication()}</h5>
                    <h6 class="card-title">Durée : ${prescription.getDuration()}</h6>

                </div>
            </div>
        </c:forEach>
    </div>

    <h2 class="text-center">Fiches de soins</h2>
    <hr>
    <div class="container p-3 ">
        <div class="row text-center justify-content-center mb-4">
            <c:forEach items="${consultation.getCareFile()}" var="careFile">
                <div class="col-md-4 mb-4">
                    <div class="card card bg-danger mb-3  " style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title ">Soin : ${careFile.getCare()}</h5>
                            <h6 class="card-title">Durée : ${careFile.getDuration()}</h6>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


</div>

</body>
</html>
