<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Riddle</title>
</head>
<body>
<h1 class="text-center fs-1 mt-3 ">Devinette</h1>
<hr>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="p-5">
                <form action="insert" method="post" enctype="multipart/form-data">

                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label for="lastName">LastName</label>
                            <input type="text" class="form-control" id="lastName" name="lastName">
                            <label for="firstName">FirstName</label>
                            <input type="text" class="form-control" id="firstName" name="firstName">
                        </div>


                        <div class="form-group col-md-6">
                            <label for="dateOfBirth">Date of Birth</label>
                            <input type="text" class="form-control" id="dateOfBirth" placeholder="dd-mm-yyyy"
                                   name="dateOfBirth">
                            <div class="mb-3">
                                <label for="formFile" class="form-label">Image</label>
                                <input class="form-control" type="file" id="formFile" name="image" accept=".png">
                            </div>
                        </div>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
