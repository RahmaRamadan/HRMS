<%-- 
    Document   : employee
    Created on : Feb 2, 2021, 3:53:16 PM
    Author     : egypt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Affairs Section</title>
        <style>
                
                *
                {
                    margin: 0;
                    padding: 0;
                }
                #nav-bar{
                    position: sticky;
                    top: 0;
                    z-index: 10;
                    background:#0065A2;
                    
                }
                .navbar-brand img{
                    height: 70px;
                    width: 120px;
                    padding-left: 30px;
                    
                }
                
                .navbar-nav li{
                    padding: 0 10px;
                }
                
                .navbar-nav li a{
                    float: right;
                    text-align: left;
                }
                
                #nav-bar ul li a:hover{
                    color: blue;
                }
                
                .navbar-toggler{
                    border: none;
                }
                
                .nav-link{
                    color: #555;
                    position:static;
                    font-weight: 600;
                    font-size: 16px;                   
                }
                
                #slider{
                    width: 100%;
                }
                
                .carousel-caption{
                    top: 85%;
                    transform: translateY(-50%);
                    bottom: initial;
                }
                
                .carousel-caption h5{
                    color: white;
                    font-size: 50px;
                }
                .d-block{
                    width: 100%;
                    height: 600px;
                }
                
                #head1{
                    color:#0065A2;
                    background-color:#F6F7FB;
                }
                
                .btn-primary{
                    display: block;
  width: 320px;
  max-width: 100%;
  margin: 0 auto;
  margin-bottom: 0;
  overflow: hidden;
  position: relative;
  transform: translatez(0);
  text-decoration: none;
  box-sizing: border-box;
  font-size: 24px;
	font-weight: normal;
	box-shadow: 0 9px 18px rgba(0,0,0,0.2);
        text-align: center;
	border-radius: 40px;
  padding: 7px;
  color: white;
  background: #BD3381;
  transition: all 0.2s ease-out 0s;
                }
                
                
           </style>   
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet"
              href ="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-
              awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com./bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <section id="nav-bar">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
      <a class="navbar-brand" href="#"><img src = "logo.jpg"> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
          <li class="nav-item">
          <a class="nav-link" href="#">ABOUT US</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">SERVICES</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">CAREERS</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"  href="homePage.jsp">HOME</a>
        </li>
        
        
         
        
      </ul>
    </div>
  </div>
</nav> 
                  <h1 id= "head1" align = "center">Employee Affairs Analysis</h1>

</section>
        <div id="slider">
            <div id="headerSlider" class="carousel slide" data-bs-ride="carousel">
  <ol class="carousel-indicators">
    <li data-bs-target="#headerSlider" data-bs-slide-to="0" class="active"></li>
    <li data-bs-target="#headerSlider" data-bs-slide-to="1"></li>
    <li data-bs-target="#headerSlider" data-bs-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block" src="analys1.jpg">
      <div class="carousel-caption">
          <h5>Data Analysis</h5>
      </div>
    </div>
    <div class="carousel-item">
      <img class="d-block" src="analys2.jpg">
       <div class="carousel-caption">
          <h5>Charts</h5>
      </div>
    </div>
    <div class="carousel-item">
      <img class="d-block" src="analys3.jpg">
       
    </div>
  </div>
  <a class="carousel-control-prev" href="#headerSlider" role="button" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </a>
  <a class="carousel-control-next" href="#headerSlider" role="button" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </a><br/>
</div>
            
        </div>
    
    
        
        <div class = "container">
        <button class = "btn-primary" onclick="window.location.href='empAff_charts.jsp' ">Show Gender Distribution</button><br/>
        <button class = "btn-primary" onclick="window.location.href='attendDataChart.jsp'">Show Employee Arrival Time</button><br/>
        
        </div>

    </body>
</html>
