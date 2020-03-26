
<%@include file="includes/indexHeader.inc"%>

<!-- Navigation -->
<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light" style="border-bottom: 2px solid black;">
    <a class="navbar-brand ml-4 c" href="FrontController?target=redirect&destination=index">
        <img src="Images/LogoUdenBaggrund.png" width="90" height="auto">
          Olsker Cupcakes
    </a>
    <div class="collapse navbar-collapse mr-4" id="navbarNavDropdown" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="FrontController?target=redirect&destination=index"><i class="fa fa-fw fa-home"></i>Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="FrontController?target=redirect&destination=login">Login</a>
            </li>
        </ul>
    </div>
</nav>



<!-- Page Content -->
<div class="container">
    <br><br>
    <div class="row">

        <div class="col-lg-3">
            <br><br>

            <img src="./Images/LogoUdenBaggrund.png" alt="Logo" width="250" height=auto>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block img-fluid" src="./Images/Slide1.jpg"
                             alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="./Images/Slide2.jpg"
                             alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="./Images/Slide3.png"
                             alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
</div>
<!-- /.container -->

<!-- Cards -->
<div class="container mt-5">

    <div class="row">

        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="FrontController?target=redirect&destination=login"><img class="card-img-top" src="./Images/bestil.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="FrontController?target=redirect&destination=login" style="text-decoration: none">Bestil Cupcakes</a>
                    </h4>
                    <p class="card-text">Her kan De bestille Danmarks bedste cupcakes! De kan frit mikse bunde
                        med toppings efter Deres smag. God fornøjelse!</p>
                </div>
            </div>
        </div>

        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="./Images/ingrediens.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#" style="text-decoration: none">Vores Ingredienser</a>
                    </h4>
                    <p class="card-text">Hvis De er interesseret i at vide mere om vores økologiske ingredienser,
                        kan de klikke her.</p>
                </div>
            </div>
        </div>

        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="./Images/Gruppe4.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#" style="text-decoration: none">Vores Gruppe</a>
                    </h4>
                    <p class="card-text">Her vil De finde vores kontakt information.</p>
                </div>
            </div>
        </div>

    </div>
    <!-- /.row -->
</div>
<!-- /.col-lg-9 -->
</div>
<!-- /.row -->

</div>
<!-- /.container -->


<!-- Footer -->
<footer class="py-5 bg-dark mt-5">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Gruppe4</p>
    </div>
    <!-- /.container -->
</footer>


</body>
</html>
