<%@page import="Application.Payroll.Payrolls"%>
<%@page import="java.sql.*"%>

<html>
    <%
        try {
            String id = request.getParameter("id");
            boolean deleteSalary = new Payrolls().deleteSalary(id);
        } catch (Exception ex) {
            out.println("ex: " + ex);
            ex.printStackTrace();
        }
    %>
    <script>
        windows.location.replace("payroll.jsp");
    </script>
</html>