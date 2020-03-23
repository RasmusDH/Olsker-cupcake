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
    if (request.getServletContext().getAttribute("customerList") == null) {
        request.getServletContext().setAttribute("customerList", Initializer.getCustomerList());
    }
    if (request.getServletContext().getAttribute("customerOrderList") == null) {
        request.getServletContext().setAttribute("customerOrderList", Initializer.getCustomerOrderList());
    }
    if (request.getServletContext().getAttribute("indiOrderList") == null) {
        request.getServletContext().setAttribute("indiOrderList", Initializer.getListOfIndiOrders());
    }
%>

<div class="container">
    <img src="Images/LoginBackground.png" class="img-fluid mb-4" alt="Logo" width="100%" height=auto>

    <h1 class="text-center mb-4">Velkommen ${sessionScope.name}</h1>

    - Man kan kun opdatere beløbet
    <br>
    - Kundelisten bliver ikke opdateret
    <br>
    - Man kan godt slette flere ordre men listen bliver ikke opdateret
    <br>
    <br>

    Indsæt beløb på kundekonto:
    <form name="balance" action="FrontController" method="POST" >
        <input type="hidden" name="target" value="balance">

        <div class="form-group">
            <label for="email">Indtast email:</label>
            <input type="text" name="email" class="form-control" id="email" placeholder="email">
        </div>
        <div class="form-group">
            <label for="amount">Indtast beløbet der skal indsættes:</label>
            <input type="number" name="amount" class="form-control" id="amount" placeholder="Beløb">
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-dark mt-3">Indsæt beløb</button>
        </div>
    </form>
    <br>
    <br>
    <br>
    <br>

    <div class="row">
        <div class="col-md-6 text-center">
            <h6>Se alle ordre:</h6>
            <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#AlleOrdre" aria-expanded="false" aria-controls="AlleOrdre">
                Alle ordre
            </button>
            <div class="collapse" id="AlleOrdre">
                <div class="card card-body">
                    <c:forEach var="order" items="${applicationScope.orderList}">
                        Ordre: ${order.orderID}. Dato: ${order.date}. Ordren er lavet af: ${order.email} (${order.customerID})
                        <br><br>
                    </c:forEach>
                </div>
            </div>
        </div>


        <div class="col-md-6 text-center">
            <h6>Slet ordre:</h6>
            <form name="employee" action="FrontController" method="POST" >
                <input type="hidden" name="target" value="employee">
                <div class="input-group mb-3">
                    <input type="number" class="form-control" name="orderID" placeholder="OrderID" aria-label="OrderID" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit">Delete</button>
                    </div>
                </div>
            </form>
            ${requestScope.message}
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-md-12 text-center">
            <h6>Se alle kunder:</h6>
            <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#AlleKunder" aria-expanded="false" aria-controls="AlleKunder">
                Alle kunder
            </button>
            <div class="collapse" id="AlleKunder">
                <div class="card card-body">
                    <c:forEach var="customer" items="${applicationScope.customerList}">
                        Kunde-${customer.id}: ${customer.name}, ${customer.email}. Saldo: ${customer.balance}
                        <br><br>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-md-4 text-center">
            <h6>Se alle kunder og deres ordre:</h6>
            <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#Ordre" aria-expanded="false" aria-controls="Ordre">
                Ordre
            </button>
            <div class="collapse" id="Ordre">
                <div class="card card-body">
                    <c:forEach var="CO" items="${applicationScope.customerOrderList}">
                        OrderID-${CO.orderID} ${CO.date}.
                        <br>Lavet af ${CO.name} (ID-${CO.customerID})
                        <br><br>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="col-md-4 text-center">
            <h6>Detaljer om individuelle ordre:</h6>
            <div class="form-group">
                <input type="number" name="orderID" class="form-control" id="orderID" placeholder="OrderID">
            </div>
            

            
            <c:forEach var="CO" items="${applicationScope.indiOrderList}">

                <br><br>
            </c:forEach>

        </div>

    </div>



    <div class="text-center mt-3">
        <a class="btn btn-outline-dark"
           href="FrontController?target=redirect&destination=index" role="button">Tilbage til start</a>
    </div>

</div>


</body>
</html>