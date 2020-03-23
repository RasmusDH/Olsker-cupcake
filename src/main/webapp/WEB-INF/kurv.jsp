<%@ page import="UtilClass.Initializer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 19-03-2020
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Kurv</title>
</head>
<body>
<%
    if (request.getServletContext().getAttribute("orderList") == null) {
        request.getServletContext().setAttribute("orderList", Initializer.getOrderList());
    }

%>
<img src="Images/LoginBackground.png" class="img-fluid mb-5" alt="Logo" width="100%" height=auto>

<br>
<hr>

<div class="col-25" align="center">
    <div class="container">
        <h4>Cart
            <span class="price" style="color:black">
                <i class="fa fa-shopping-cart"></i>
            </span>
        </h4>
        <div class="card card-body">
            <c:forEach var="cupcake" items="${sessionScope.cart}">
                ${cupcake}
                <br><br>
            </c:forEach>
        </div>
        <hr>
        <p>Total: <span class="price" style="color:black"><b>${sessionScope.finalPrice}</b></span></p>
    </div>

<br>
    <div class="text-center mt-3 mb-3">
        <a href="FrontController?target=redirect&destination=bestilling"
           class="btn btn-primary mt-4 mb-3" role="button" aria-pressed="true">Bestil flere</a>
    </div>
<br>
    <div class="text-center mt-3">
        <a href="#"
           class="btn btn-primary mt-5" role="button" aria-pressed="true">Betal</a>
    </div>

</div>


</body>
</html>
