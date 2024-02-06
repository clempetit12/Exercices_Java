<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <head>
        <title>Formulaire création patient</title>
        <jsp:include page="../../includes/head.jsp"/>

    </head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<h1 class="text-center fs-1 mt-3 ">Formulaire ajout tâche</h1>
<hr>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="p-5">
                <form action="task" method="post">

                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label for="content">Content</label>
                            <input type="text" class="form-control" id="content" name="content">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="done">
                                <label class="form-check-label" for="done">
                                    Done
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="inProcess" checked>
                                <label class="form-check-label" for="inProcess">
                                    In Process
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="toBeDone" checked>
                                <label class="form-check-label" for="toBeDone">
                                    To be done
                                </label>
                            </div>
                        </div>

                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">

                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
