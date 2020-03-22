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


    <title>Kurv</title>
</head>
<body>
<%
    if (request.getServletContext().getAttribute("orderList") == null) {
        request.getServletContext().setAttribute("orderList", Initializer.getOrderList());
    }

%>
<img src="Images/LoginBackground.png" class="img-fluid mb-4" alt="Logo" width="100%" height=auto>
<hr>

<div class="col-25" align="center">
    <div class="container">
        <h4>Cart
            <span class="price" style="color:black">
          <i class="fa fa-shopping-cart"></i>

        </span>
        </h4>
        <div class="card card-body">
        <c:forEach var="order" items="${sessionScope.cupcakeList}">
            ${order}
            <br>
        </c:forEach>
        </div>
        <hr>
        <p>Total: <span class="price" style="color:black"><b>${sessionScope.finalPrice}</b></span></p>
    </div>
</div>
<button onclick="goBack()">Go Back</button>


</body>
</html>
