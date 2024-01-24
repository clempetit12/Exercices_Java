<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="includes/head.jsp" />
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-bm8igQNihO1Ie6psA1cFy2oDR3xg6sBCpiYVpxd9fxd4U5P8jc6pLMVyGxgP4MZ" crossorigin="anonymous"></script>
    <title>Login Success Page</title>
</head>
<body>
<jsp:include page="includes/header.jsp" />
<%

    String user = null;
    if(session.getAttribute("user") == null){
        response.sendRedirect("index.jsp");
    }else user = (String) session.getAttribute("user");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>
<%-- Vérifiez si la variable de session "message" est définie --%>
<% if (session.getAttribute("toastMessage") != null) { %>
<div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-header">
        <img src="..." class="rounded me-2" alt="...">
        <strong class="me-auto">Bootstrap</strong>
        <small>Now</small>
        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
    <div class="toast-body">
        <%= session.getAttribute("message") %>
    </div>
</div>
<%-- Effacez la variable de session "message" après l'avoir affichée --%>
<% session.removeAttribute("message"); } %>

<a href="checkoutPage.jsp">Checkout Page</a>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>
