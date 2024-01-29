
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail patient</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp" />

<h1 class="text-center">Détail patient</h1>
<a href="form" type="button">Add</a>


    <div class="card" style="width: 18rem;">
        <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getIdPatient()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image du Patient"></td>
        <div class="card-body">
            <h5 class="card-title">Nom : ${patient.getLastName()}</h5>
            <h6 class="card-title">Prénom : ${patient.getFirstName()}</h6>
            <h6 class="card-title">Date de naissance : ${patient.getDateOfBirth()}</h6>

        </div>
    </div>


<a href="formConsultation?id=${patient.getIdPatient()}" type="button" > Add  Consultation </a>


<h2>Liste des consultations </h2>

<table border="1" cellpadding="5" class="table table-dark text-center" >
    <caption><h2>List of Consultations</h2></caption>
    <tr>
        <th>Id</th>
        <th>Nom Docteur</th>
        <th>Date Consultation</th>
        <th>Détail Consultation</th>

    </tr>
            <c:forEach items="${patient.getConsultationList()}" var="consultation">
                <tr>
                    <td>${consultation.getIdConsultation()}</td>
                    <td>${consultation.getDoctorName()}</td>
                    <td>${consultation.getConsultationDate()}</td>
                    <td> <a type="button" href="detailsConsultation?id=${consultation.getIdConsultation()}" class="btn btn-primary">Detail</a></td>

                </tr>
            </c:forEach>


</table>

</div>





</body>
</html>
