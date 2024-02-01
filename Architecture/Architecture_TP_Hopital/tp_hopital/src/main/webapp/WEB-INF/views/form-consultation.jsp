<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire création consultation</title>
    <jsp:include page="../../includes/head.jsp"/>
</head>
<body>

<jsp:include page="../../includes/header.jsp"/>
<div class="container p-4">
    <h1 class="text-center">Formulaire ajout consultation</h1>
    <hr>
    <form action="insertConsultation" method="post">

        <input type="hidden" name="patientId" value="${param.id}">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="doctorName">Doctor Name</label>
                <input type="text" class="form-control" id="doctorName" name="doctorName">
            </div>
            <div class="form-group col-md-6">
                <label for="dateConsultation">Date Consultation</label>
                <input type="text" class="form-control" id="dateConsultation" name="dateConsultation">
            </div>

        </div>


        <div id="careFiles">
            <h4>CareFiles</h4>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="care">Care</label>
                    <input type="text" class="form-control" id="care" name="care[]" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="duration">Duration (days)</label>
                    <input type="number" class="form-control" id="duration" name="duration[]" required>
                </div>
                <div class="d-flex justify-content-end">
                    <button type="button " class="btn btn-warning" onclick="addCareFile()">Add Care File</button>
                </div>
            </div>

        </div>


        <div id="prescriptions">
            <h4>Prescriptions</h4>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="medication">Medication</label>
                    <input type="text" class="form-control" id="medication" name="medication[]" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="durationM">Duration (days)</label>
                    <input type="number" class="form-control" id="durationM" name="durationM[]" required>
                </div>
                <button type="button" class="btn btn-warning mb-3" onclick="addPrescription()">Add Prescription</button>
            </div>

        </div>


        <div class="d-grid gap-2 d-md-flex justify-content-md-end">

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

</div>


</body>
</html>

</head>
<body>

<script>
    function addCareFile() {
        var container = document.getElementById("careFiles");
        var newRow = document.createElement("div");
        newRow.className = "care-file-row";
        newRow.innerHTML = '<div class="form-row">' +
            '<div class="form-group col-md-6">' +
            '<label for="care">Care</label>' +
            '<input type="text" class="form-control" name="care[]" required>' +
            '</div>' +
            '<div class="form-group col-md-6">' +
            '<label for="duration">Duration (days)</label>' +
            '<input type="number" class="form-control" name="duration[]" required>' +
            '</div>' +
            '</div>';
        container.appendChild(newRow);
    }

    function addPrescription() {
        var container = document.getElementById("prescriptions");
        var newRow = document.createElement("div");
        newRow.className = "prescription-row";
        newRow.innerHTML = '<div class="form-row">' +
            '<div class="form-group col-md-6">' +
            '<label for="medication">Medication</label>' +
            '<input type="text" class="form-control" name="medication[]" required>' +
            '</div>' +
            '<div class="form-group col-md-6">' +
            '<label for="durationM">Duration (days)</label>' +
            '<input type="number" class="form-control" name="durationM[]" required>' +
            '</div>' +
            '</div>';
        container.appendChild(newRow);
    }
</script>
</body>
</html>

