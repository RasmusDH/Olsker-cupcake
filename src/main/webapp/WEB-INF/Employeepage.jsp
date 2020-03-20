<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="UtilClass.Initializer" %><%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 20-03-2020
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


    <title>Employee</title>

</head>
<body>

<%
    if (request.getServletContext().getAttribute("orderList") == null) {
        request.getServletContext().setAttribute("orderList", Initializer.getOrderList());
    }
    if (request.getServletContext().getAttribute("bottomList") == null) {
        request.getServletContext().setAttribute("bottomList", Initializer.getBottomList());
    }
%>

<div class="container">
    <img src="Images/LoginBackground.png" class="img-fluid mb-4" alt="Logo" width="100%" height=auto>

    <h1 class="text-center mb-4">Velkommen ${sessionScope.name}</h1>

    Indsæt beløb på kundekonto:
    - Mangler

    <br>
    <br>
    <br>
    <br>

    <div class="text-center mt-3">
        <h5>Alle ordre:</h5>
        <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            Alle ordre
        </button>
        <div class="collapse" id="collapseExample">
            <div class="card card-body">
                        <c:forEach var="order" items="${applicationScope.orderList}">
                            ${order.date}
                            <br>
                        </c:forEach>
            </div>
        </div>
    </div>


    <div class="text-center mt-3">
        <a class="btn btn-outline-dark"
           href="FrontController?target=redirect&destination=index" role="button">Tilbage til start</a>
    </div>

</div>


</body>
</html>
