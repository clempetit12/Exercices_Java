<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire création patient</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp" />

<form action="insert" method="post" enctype="multipart/form-data">

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="lastName">LastName</label>
            <input type="text" class="form-control" id="lastName" name="lastName" >
        </div>
    </div>
        <div class="form-group col-md-6">
            <label for="firstName">FirstName</label>
            <input type="text" class="form-control" id="firstName" name="firstName" >
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="dateOfBirth">Date of Birth</label>
            <input type="text" class="form-control" id="dateOfBirth" placeholder="dd-mm-yyyy" name="dateOfBirth" >
        </div>
        <div class="form-row">
            <div class="mb-3">
                <label for="formFile" class="form-label">Image</label>
                <input class="form-control" type="file" id="formFile" name="image" accept=".png" >
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>

</body>


</html>
