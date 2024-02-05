<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail patient</title>
    <jsp:include page="../../includes/head.jsp"/>
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>

<div class="container p-3">
    <h1 class="text-center fs-1 mt-3 mb-4 ">Détail patient</h1>
    <hr>


    <div class="row justify-content-center">

        <div class="card " style="width: 18rem;">
            <div class="text-center ">
                <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getIdPatient()}"
                     class="img-thumbnail" style="width: 100px;height: 100px;" alt="Image du Patient"></td>
            </div>

            <div class="card-body">
                <h5 class="card-title">Nom : ${patient.getLastName()}</h5>
                <h6 class="card-title">Prénom : ${patient.getFirstName()}</h6>
                <h6 class="card-title">Date de naissance : ${patient.getDateOfBirth()}</h6>
                <div class="text-center">
                    <a type="button" href="delete?id=${patient.getIdPatient()}" class="btn btn-danger">Delete</a>
                </div>

            </div>
        </div>

    </div>

    <table class="table table-dark table-striped">

        <tr>
            <th class="center text-center">Id</th>
            <th class="center text-center">Nom Docteur</th>
            <th class="center text-center">Date Consultation</th>
            <th class="center text-center">Détail Consultation</th>

        </tr>

        <c:if test="${not empty patient.getConsultationList()}">
            <c:forEach  items="${patient.getConsultationList()}" var="consultation">


                <tr>
                    <td class="center text-center">${consultation.getIdConsultation()}</td>
                    <td class="center text-center">${consultation.getDoctorName()}</td>
                    <td class="center text-center">${consultation.getConsultationDate()}</td>
                    <td class="center text-center">
                        <a type="button" href="detailsConsultation?id=${consultation.getIdConsultation()}"
                           class="btn btn-warning">Detail</a></td>

                </tr>

            </c:forEach>
        </c:if>

        <div class="d-grid gap-2 d-md-flex justify-content-md-end">


        </div>

    </table>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">

        <a href="formConsultation?id=${patient.getIdPatient()}" class="btn btn-primary mb-3" role="button"><i
                class="bi bi-plus-square"></i> Add Consultation</a>
    </div>
</div>


</div>


</body>
</html>
