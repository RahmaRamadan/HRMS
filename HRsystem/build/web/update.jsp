<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="Entity.Employee_Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataAccess.DatabaseConnection"%>


<%-- 
    Document   : update
    Created on : Feb 2, 2021, 7:10:37 PM
    Author     : egypt2
--%>

<%@page import="java.sql.Connection"%>
<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.logging.Level"%>
<%@page import= "java.util.logging.Logger" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Registration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        
        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');


            * {
                margin:0;
                padding:0;
                user-select: none;   
                font-family: 'Poppins', sans-serif;
                box-sizing:border-box;
                -webkit-box-sizing:border-box;
                -moz-box-sizing:border-box;
                -webkit-font-smoothing:antialiased;
                -moz-font-smoothing:antialiased;
                -o-font-smoothing:antialiased;
                font-smoothing:antialiased;
                text-rendering:optimizeLegibility;
            }
 .navBar {
                overflow: hidden;
                padding-right: 20px;
                padding-left: 40px;
                padding-top: 20px;
                }

            .navBar a {
                float: right;
                color: #0492C2;
                background: none;
                text-align: center;
                padding: 20px 20px;
                text-decoration: none;
                font-size: 18px;
                }
            .navBar a:hover {
                background: none;
                color: #0492C2;
                }

            .navBar a.back {
                color: cadetblue;
                float: left;
               }
            .logo {
                color: white;
                float: left;

                height: 50px;
                width: 100px;
                }
           
            .btn-suc{
                position: absolute;
                top: 100px;
                left: 40px;
                height: 45px;
                width: 45px;
                text-align: center;
                background: #eae9e9;
                border-radius: 3px;
                cursor: pointer;
                transition: left 0.4s ease;
            }
            .btn-suc.click{
                left: 220px;
            }
            .btn-suc span{
                color: #0492C2;
                font-size: 28px;
                line-height: 40px;
            }
            .btn-suc.click span:before{
                content: '\f00d';
            }
           
            .text{
                background: gray;
            }
            
            .container {
                max-width:800px;
                width:100%;
                margin:0 auto;
                position:relative;
            }



            .btn-success1{
                background-color:#0492C2;
            }

            .btn-success1:hover{
                background-color:cornflowerblue;
            }

            .form-group{
                font-size: 15px;
                font-style:normal;
            }
            h2{
                color:#0492C2;
            }
        </style>
    </head>
    <body>
        <%

            Connection con;
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
               try {
                   
                   Employee_Data emp = new Employee_Data(request.getParameter("id"),request.getParameter("first_name"),
                   request.getParameter("last_name"),request.getParameter("gender"),request.getParameter("username"),request.getParameter("password"),
                   request.getParameter("address"),request.getParameter("salary"), request.getParameter("position"),
                   request.getParameter("numOfVacations"), request.getParameter("hiring_date"), request.getParameter("age"),
                   request.getParameter("empType"),request.getParameter("dep_id"),request.getParameter("type"), request.getParameter("hrComponent") );
                
                 boolean updateEmployees = new Employees_Affairs().updateEmployee(emp);
                 
                 if (updateEmployees && !(request.getParameter("id").equals(""))) {
                    color = "blue"; 
                    message = "Employee Updated Successfully";
                    
                } else {
                    color = "red";
                    message = "Error Occured";
                }

                } catch (Exception ex) {
                    out.println("ex: " + ex);
                    
                }
            }
        %>
        <div class="form-group col-12 p-0">
            <h4 style ="color: <%= color%>"><%= message%></h4>
        </div>
        <form id="form" method="post" action="update.jsp" class="form-horizontal">
            <%
                PreparedStatement pat;
                ResultSet rs;
                
                con = DatabaseConnection.getConnection();
                String id = request.getParameter("id");
                pat = con.prepareStatement("select * from employee where id = ?");
                pat.setString(1, id);
                rs = pat.executeQuery();
                while (rs.next()) {

            %>
            <div class="navBar">
             <img class="logo" src = "logo.jpg" >
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a   href="careers.jsp">CAREERS</a>
            <a href="navBar.jsp"<i class="fa fa-home"></i> HR HOME</a>
            

        </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <h2 style="text-align: center">Employee Details</h2>
                </div>
            </div>
            <hr/>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="id"> ID </label>
                    <input type="text" name="id" class="form-control" id ="id"  value = "<%= rs.getString("id")%>">

                </div>     
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="firstname"> First Name </label>
                    <input type="text" name="first_name" class="form-control" id ="first"  value = "<%=rs.getString("first_name")%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="lastname"> Last Name </label>
                    <input type="text" name="last_name" class="form-control" id ="last"  value = "<%=rs.getString("last_name")%>">
                </div>
            </div>
             <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="gender"> Gender </label>
                    <input type="text" list="genderr" autocomplete="off" name="gender" class="form-control" id ="last"  value = "<%=rs.getString("gender")%>">
                    <datalist id="genderr">
                        <option>Male</option>
                        <option>Female</option>
                    </datalist>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="username"> User Name </label>
                    <input type="text" name="username" class="form-control" id ="uname"  value = "<%=rs.getString("username")%>">
                </div>
            </div>
                
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="password"> Password </label>
                    <input type="text" name="password" class="form-control" id ="pass"  value = "<%=rs.getString("password")%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="address"> Address</label>
                    <input type="text" name="address" class="form-control" id ="addressE"  value = "<%=rs.getString("address")%>">
                </div>
            </div>
           
                
                <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="salary"> Salary </label>
                    <input type="text" name="salary" class="form-control" id ="salary"  value = "<%=rs.getString("salary")%>">
                </div>
            </div>
                
                <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="position"> Position </label>
                    <input type="text" name="position" class="form-control" id ="position"  value = "<%=rs.getString("position")%>">
                </div>
            </div>
           
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="numOfVacations"> Number of Vacation days available </label>
                    <input type="text" name="numOfVacations" class="form-control" id ="numOfVacations"  value = "<%=rs.getString("numOfVacations")%>">
                </div>
            </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="hiring_date"> Hiring Date </label>
                    <input type="text" name="hiring_date" class="form-control" id ="hiring_date"  value = "<%=rs.getString("hiring_date")%>">
                </div>
            </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="age"> Age </label>
                    <input type="text" name="age" class="form-control" id ="age"  value = "<%=rs.getString("age")%>">
                </div>
            </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="empType"> Type </label>
                    <input type="text" list="mangOrEmp" autocomplete="off" name="empType" class="form-control" id ="empType"  value = "<%=rs.getString("empType")%>">
                     <datalist id="mangOrEmp">
                        <option>Manager</option>
                        <option>Employee</option>
                    </datalist>

                </div>
            </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="dep_id"> Department ID </label>
                    <input type="text" list="depID" autocomplete="off" name="dep_id" class="form-control" id ="dep_id"  value = "<%=rs.getString("dep_id")%>">
                    <datalist id="depID">
                <option>HR11</option>
                <option>FIN11</option>
                <option>MAR11</option>
                <option>SAL11</option>
                <option>IT11</option>
                <option>ACC11</option>
                <option>GEN11</option>
                </datalist>
                </div>
            </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="type"> Department </label>
                    <input type="text" list="typee" autocomplete="off" name="type" class="form-control" id ="type"  value = "<%=rs.getString("type")%>">
                    <datalist id="typee">
                <option>Human Resources</option>
                <option>Finance</option>
                <option>Marketing</option>
                <option>Sales</option>
                <option>Information Technology</option>
                <option>Accounting</option>
                <option>General</option>
                </datalist>
                
            </div>
                 </div>
                 <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label for="hrComp"> HR Component </label>
                    <input type="text" list="hrComp" autocomplete="off" name="hrComponent" class="form-control" id ="hrComponent"  value = "<%=rs.getString("hrComponent")%>">
                     <datalist id="hrComp">
                <option>Employee Affairs</option>
                <option>Recruitment</option>
                <option>Payroll</option>
                <option>Evaluation</option>
                </datalist>
                </div>
            </div>
            <br/>
            <div class="form-group" align="center">
                <div class="col-sm-2">
                    <Button class="btn btn-success1" style="width: 120px">Submit</Button>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
            <% } %>
        </form>
        <br>
                                
    </body>
</html>
