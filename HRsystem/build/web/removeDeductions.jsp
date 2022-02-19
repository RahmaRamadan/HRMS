<%@page import="Application.Payroll.Payrolls"%>
<%@page import="java.sql.*"%>

<html>
    <%
         String id = request.getParameter("id");
        out.print(id);
        boolean deleteEmp = new Payrolls().deleteDeductions(id);
        out.print(deleteEmp);
        if (deleteEmp) {
            // alert emplyee is deleted
            out.print("Employee is deleted successfully");
        } else {
            // alert emp is not deleted
            out.print("Error Occured");
        }
    %>
    <script>
        windows.location.replace("cashAdvance.jsp");
    </script>
</html>