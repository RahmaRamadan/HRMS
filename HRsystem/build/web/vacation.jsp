<%-- 
    Document   : vacation
    Created on : Feb 2, 2021, 7:32:45 PM
    Author     : egypt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vacations Request</title>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600);

* {
	margin:20px;
	padding:0;
	box-sizing:border-box;
	-webkit-box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-font-smoothing:antialiased;
	-moz-font-smoothing:antialiased;
	-o-font-smoothing:antialiased;
	font-smoothing:antialiased;
	text-rendering:optimizeLegibility;
}

body {
	font-family:"Open Sans", Helvetica, Arial, sans-serif;
	font-weight:300;
	font-size: 12px;
	line-height:30px;
	color:#777;
	background:white;
}

.container {
	max-width:500px;
	width:100%;
                height: 800px;
	margin:0 auto;
	position:relative;
}



#contact {
	background:buttonface;
	padding:25px;
	margin:50px 0;
}

#contact h3 {
	color: #0492C2;
	display: block;
	font-size: 30px;
	font-weight:bold;
        margin:5px 0 25px;
}



fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="text"], #contact input[type="text"], #contact input[type="date"],#contact input[type="number"],#contact textarea {
	width:100%;
	border:1px solid #CCC;
	background:#FFF;
	margin:0 0 5px;
	padding:10px;
}

#contact input[type="text"]:hover, #contact input[type="text"]:hover, #contact input[type="text"]:hover, #contact input[type="date"]:hover,#contact input[type="number"]:hover, #contact textarea:hover {
	-webkit-transition:border-color 0.3s ease-in-out;
	-moz-transition:border-color 0.3s ease-in-out;
	transition:border-color 0.3s ease-in-out;
	border:1px solid #AAA;
}

#contact textarea {
	height:100px;
	max-width:100%;
  resize:none;
}

#contact button[type="submit"] {
	cursor:pointer;
	width:100%;
	border:none;
	background:#0492C2;
	color:#FFF;
	margin:0 0 5px;
	padding:10px;
	font-size:15px;
}

#contact button[type="submit"]:hover {
	background:#09C;
	-webkit-transition:background 0.3s ease-in-out;
	-moz-transition:background 0.3s ease-in-out;
	transition:background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active { box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5); }

#contact input:focus, #contact textarea:focus {
	outline:0;
	border:1px solid #999;
}
::-webkit-input-placeholder {
 color:#888;
}
:-moz-placeholder {
 color:#888;
}
::-moz-placeholder {
 color:#888;
}
:-ms-input-placeholder {
 color:#888;
}

#datee{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 10px;
}   

#numDays{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 10px;
}
#vacs{
    height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 10px;
}  


        </style>
    </head>
    <body>
        <div class="container">  
  <form id="contact" action="vacationData.jsp" method="get">
    <h3>Vacation Form</h3>
    <fieldset >
      <input name = "nameField" placeholder="Name" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset >
      <input name = "idField" placeholder="ID" type="text" tabindex="2" required>
    </fieldset>
    <fieldset >
      <input name = "jobField" placeholder="Job" type="text" tabindex="3" required>
    </fieldset>
    <fieldset >
      <input name ="datee" placeholder="Date" type="date" tabindex="4" required>
    </fieldset>
    <fieldset >
        
  <select id="vacs" name="vactions" tabindex="5" required>
    <option value="" disabled selected>Choose Vacation Type:</option> 
    <option value="req">Regular</option>
    <option value="opp">Opposing</option>
    <option value="morb">Morbidity</option>
    <option value="per">Permission</option>
  </select>
    </fieldset>
    <fieldset>
      <input name="numDays" placeholder="Number of Days" type="number" tabindex="6" required>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Make Request</button>
    </fieldset>
  
  </form>
 
  
</div>
      
    </body>
</html>
