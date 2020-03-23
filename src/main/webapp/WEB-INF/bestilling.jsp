<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="UtilClass.Initializer" %><%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 16-03-2020
  Time: 09:28
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

    <!-- Til Dropdown -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Bestilling</title>


</head>
<body>


<div class="container">
    <img src="Images/LoginBackground.png" class="img-fluid mb-4" alt="Logo" width="100%" height=auto>

    <p>${sessionScope.toppingPrice}</p>


    <!-- Dropdowns -->
    <form action="FrontController" method="post">
        <input type="hidden" name="target" value="bestilling">

        <div class="row">

            <div class="col-md-5 school-options-dropdown text-center">
                <div class="form-group">
                    <label >Vælg bund:</label>
                    <select class="form-control" name="bund">
                        <c:forEach var="bottom" items="${bottoms}">
                            <option name="bund">${bottom.name}, ${bottom.bottomPrice}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col-md-5 school-options-dropdown text-center">
                <div class="form-group">
                    <label>Vælg topping:</label>
                    <select class="form-control" name="top">
                        <c:forEach var="topping" items="${toppings}">
                            <option name="top">${topping.name}, ${topping.toppingPrice}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="col-md-2 school-options text-center">
                <div class="form-group">
                    <p>Indtast antal</p>
                    <input name="quantity" type="text">
                </div>
            </div>

        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary mt-4">Tilføj til kurv</button>
        </div>
        <div class="text-center">
            <a href="FrontController?target=redirect&destination=kurv"
               class="btn btn-primary mt-4" role="button" aria-pressed="true">Gå til kurv</a>
        </div>

    </form>

</div>
</div>
<!-- /.container -->


<!-- Footer -->
<footer class="py-5 bg-dark mt-4" style="position: absolute; bottom: 0; width: 100%">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Gruppe4</p>
    </div>
    <!-- /.container -->
</footer>

</body>
</html>
