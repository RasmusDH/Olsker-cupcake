<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 16-03-2020
  Time: 12:58
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
    <title>Registrering</title>
</head>
<body>

<div class="container">
    <img src="Images/LoginBackground.png" class="img-fluid mb-4" alt="Logo" width="100%" height=auto>

    <h1 class="text-center mb-4">Registrer</h1>

    <div class="row">

        <div class="col-lg-4"></div>

        <div class="col-lg-4">

            <form name="registrer" action="FrontController" method="post">

                <input type="hidden" name="target" value="registrer"/>

                <div class="form-group">
                    <label for="navn">Indtast dit navn:</label>
                    <input type="text" name="navn" class="form-control" id="navn" aria-describedby="navnHelp">
                </div>
                <div class="form-group">
                    <label for="email">Indtast din email:</label>
                    <input type="text" name="email" class="form-control" id="email" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="password1">Indtast dit password:</label>
                    <input type="password" name="password1" class="form-control" id="password1">
                </div>
                <div class="form-group">
                    <label for="password2">Indtast dit password igen:</label>
                    <input type="password" name="password2" class="form-control" id="password2">
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-dark mt-3">Registrer</button>
                </div>

                <div class="text-center mt-3">
                    <a class="btn btn-outline-dark" href="FrontController?target=redirect&destination=login" role="button">Tilbage til Login</a>
                </div>

            </form>
        </div>

        <div class="col-lg-4"></div>

    </div>  <!-- row -->
</div>

<!-- Footer -->
<footer class="py-5 bg-dark mt-4">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Gruppe4</p>
    </div>
    <!-- /.container -->
</footer>

</body>
</html>
