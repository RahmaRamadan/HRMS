/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import DataAccess.DatabaseConnection;
import DataAccess.EmployeesAffairs.Employee_DataAccess_Interface;
import DataAccess.Evaluation.Training_Data_Access;
import Entity.Department;
import Entity.Employee_Data;
import Entity.HR_Employee_Data;
import Entity.HR_Type;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class MySQL_Employee_DataAccess implements Employee_DataAccess_Interface, Genetic_Algorithm_Interface {

    private static String typee;

    @Override
    public boolean insertEmployee(Employee_Data employee) throws Exception {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "INSERT INTO employee(id,first_name,last_name,gender,username,password,address,salary,position,numOfVacations,hiring_date,age,empType,dep_id,type,hrComponent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String query2 = "INSERT INTO salary(gross,emp_id,empName) VALUES (?,?,?)";
            String query3 = "INSERT INTO deductions(emp_id,empName) VALUES (?,?)";
            String query4 = "INSERT INTO cashadvance(emp_id,empName) VALUES (?,?)";
            String query5 = "INSERT INTO salaryhistory(amount,date,empID) VALUES (?,?,?)";
            String query6 = " insert into skills (emp_id,Skill) VALUES (?, ?)";

            PreparedStatement pat = con.prepareStatement(query);
            PreparedStatement pat2 = con.prepareStatement(query2);
            PreparedStatement pat3 = con.prepareStatement(query3);
            PreparedStatement pat4 = con.prepareStatement(query4);
            PreparedStatement pat5 = con.prepareStatement(query5);
            PreparedStatement pat6 = con.prepareStatement(query6);
            if ((employee.getDepartment()).equals("Human Resources")) {

                pat.setString(1, employee.getID());
                pat.setString(2, employee.getFName());
                pat.setString(3, employee.getLName());
                pat.setString(4, employee.getGender());
                pat.setString(5, employee.getUsername());
                pat.setString(6, employee.getPassword());
                pat.setString(7, employee.getAddress());
                pat.setString(8, employee.getSalary()); /// to double 
                pat.setString(9, employee.getTitle());
                //pat.setInt(9, numberOfVacs);
                pat.setString(10, employee.getNVacations());
                pat.setString(11, employee.getHiringDate()); // to date
                //pat.setInt(11, age2);
                pat.setString(12, employee.getAge());
                pat.setString(13, employee.getEmpType());
                pat.setString(14, employee.getDepartmentID());
                pat.setString(15, employee.getDepartment());
                pat.setString(16, employee.getHrComp());
                pat.executeUpdate();
                pat.close();
                
                pat2.setString(1, employee.getSalary());
                pat2.setString(2, employee.getID()); 
                pat2.setString(3, employee.getFName());
                pat2.executeUpdate();
                pat2.close();

                pat3.setString(1, employee.getID());
                pat3.setString(2, employee.getFName());
                pat3.executeUpdate();
                pat3.close();

                pat4.setString(1, employee.getID());
                pat4.setString(2, employee.getFName());
                pat4.executeUpdate();
                pat4.close();
                
                pat5.setString(1, employee.getSalary());
                pat5.setString(2, employee.getHiringDate());
                pat5.setString(3, employee.getID());
                pat5.executeUpdate();
                pat5.close();
                
                for (int i = 0; i < employee.getSkills().size(); i++)
                {
                pat6.setString(1, employee.getID());
                pat6.setString(2, employee.getSkills().get(i));
                pat6.execute();
                }
                pat6.close();

                con.close();

                return true;

            } else {
                pat.setString(1, employee.getID());
                pat.setString(2, employee.getFName());
                pat.setString(3, employee.getLName());
                pat.setString(4, employee.getGender());
                pat.setString(5, employee.getUsername());
                pat.setString(6, employee.getPassword());
                pat.setString(7, employee.getAddress());
                pat.setString(8, employee.getSalary()); /// to double 
                pat.setString(9, employee.getTitle());
                //pat.setInt(9, numberOfVacs);
                pat.setString(10, employee.getNVacations());
                pat.setString(11, employee.getHiringDate()); // to date
                //pat.setInt(11, age2);
                pat.setString(12, employee.getAge());
                pat.setString(13, employee.getEmpType());
                pat.setString(14, employee.getDepartmentID());
                pat.setString(15, employee.getDepartment());
                pat.setString(16, null);
                pat.executeUpdate();
                pat.close();
                
                pat2.setString(1, employee.getSalary());
                pat2.setString(2, employee.getID()); 
                pat2.setString(3, employee.getFName());
                pat2.executeUpdate();
                pat2.close();
                
                pat3.setString(1, employee.getID());
                pat3.setString(2, employee.getFName());
                pat3.executeUpdate();
                pat3.close();

                pat4.setString(1, employee.getID());
                pat4.setString(2, employee.getFName());
                pat4.executeUpdate();
                pat4.close();
                
                pat5.setString(1, employee.getSalary());
                pat5.setString(2, employee.getHiringDate());
                pat5.setString(3, employee.getID());
                pat5.executeUpdate();
                pat5.close();
                
                for (int i = 0; i < employee.getSkills().size(); i++)
                {
                pat6.setString(1, employee.getID());
                pat6.setString(2, employee.getSkills().get(i));
                pat6.execute();
                }
                pat6.close();
                con.close();
                return true;
            }

        } catch (Exception ex) {

            return false;
        }

    }

    @Override
    public boolean deleteEmployee(String id) throws Exception {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "delete from employee where id = ?";
            PreparedStatement pat = con.prepareStatement(query);
            pat.setString(1, id);
            pat.executeUpdate();
            pat.close();
            con.close();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public Employee_Data getEmployeeByID(String id) throws Exception {
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from employee where id = ?";

        PreparedStatement pat = con.prepareStatement(query);
        ResultSet rs = pat.executeQuery();
        Employee_Data employee = null;
        while (rs.next()) {
            // if it is hr
            if (rs.getString("department").equals("HumanResources")) { // change ir to suitable name
                //   Employee_Data emp = new HR_Employee_Data(rs.getString(employee.getID()),rs.getString(employee.getFName()),rs.getString(employee.getLName()), rs.getString(employee.getUsername()), rs.getString(employee.getPassword()), rs.getString(employee.getAddress()),rs.getString(employee.getSalary()), rs.getString(employee.getTitle())); // complete with rs.get...
                // the constructor is:
                //public HR_Employee_Data(String id, String fname, String lname, String user_name, 
                //String pass, String add, double salar, String title_, int nVacations_,
                //Date hiring_Date, int age_, Department depart, boolean isManage, ArrayList<HR_Type> types_) 
            } else {//if not hr
                //   Employee_Data emp = new Employee_Data();
                // (String id, String fname, String lname,String user_name,String pass, String add, double salar,

            }

        }
        pat.close();
        con.close();
        return employee;

    }

    @Override
    public ArrayList<Employee_Data> getEmployees(String search) throws Exception {

        Connection con = DatabaseConnection.getConnection();
        String query;
        //String search = request.getParameter("q");
        if (search != null) {
            query = "select * from employee where first_name like '%" + search + "%'"
                    + "or last_name like '%" + search + "%' or username like '%" + search + "%' or address like '%" + search + "%' or password like '%" + search + "%' or id like '%" + search + "%' or salary like '%" + search + "%' or position like '%" + search + "%' ";
        } else {

            query = "Select * from employee";
        }
        PreparedStatement pat = con.prepareStatement(query);
        ResultSet rs = pat.executeQuery();
        ArrayList<Employee_Data> employees = new ArrayList<>();
        while (rs.next()) {
            // if it is hr
            // if (rs.getString("department").equals("HumanResources")) { // change ir to suitable name
            Employee_Data emp; // complete with rs.get...
            emp = new HR_Employee_Data(rs.getString("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
                    rs.getString("username"), rs.getString("password"), rs.getString("address"), rs.getString("salary"), rs.getString("position"),
                    rs.getString("numOfVacations"), rs.getString("hiring_date"), rs.getString("age"), rs.getString("empType"),
                    rs.getString("dep_id"), rs.getString("type"), rs.getString("hrComponent"));
            // the constructor is:
            //public HR_Employee_Data(String id, String fname, String lname, String user_name, 
            //String pass, String add, double salar, String title_, int nVacations_,
            //Date hiring_Date, int age_, Department depart, boolean isManage, ArrayList<HR_Type> types_) 
            employees.add(emp);
            /* } else {//if not hr
                //Employee_Data emp = new Employee_Data();
                // (String id, String fname, String lname,String user_name,String pass, String add, double salar,
                //String title_ , int nVacations_, Date hiring_Date, int age_, Department depart )
              //  employees.add(emp);

            }*/

//                    < th scope = "row" > <  %= rs.getString("id") % > <  / th
//                    > <td> < %= rs.getString("first_name") % > <  / td
//                    > <td> < %= rs.getString("last_name") % > <  / td
//                    > <td> < %= rs.getString("address") % > <  / td
//                    > <td> < %= rs.getString("username") % > <  / td
//                    > <td> < %= rs.getString("salary") % > <  / td
//                    > <td> < %= rs.getString("position") % > <  / td
//                    > <td> < a 
        }
        pat.close();
        con.close();
        return employees;
    } // what about adding department???

    public boolean updateEmployee(Employee_Data employee) throws Exception {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "update employee set id = ?, first_name = ?,"
                    + " last_name = ?, gender = ?, username = ?, password = ?, address = ?, salary = ?, position = ?, numOfVacations = ?, hiring_date = ?,"
                    + "age = ?, empType = ?, dep_id = ?, type = ?, hrComponent = ? where id = ?";

            PreparedStatement pat = con.prepareStatement(query);
            System.out.println(query);
            pat.setString(1, employee.getID());
            pat.setString(2, employee.getFName());
            pat.setString(3, employee.getLName());
            pat.setString(4, employee.getGender());
            pat.setString(5, employee.getUsername());
            pat.setString(6, employee.getPassword());
            pat.setString(7, employee.getAddress());
            pat.setString(8, employee.getSalary());
            pat.setString(9, employee.getTitle());
            pat.setString(10, employee.getNVacations());
            pat.setString(11, employee.getHiringDate());
            pat.setString(12, employee.getAge());
            pat.setString(13, employee.getEmpType());
            pat.setString(14, employee.getDepartmentID());
            pat.setString(15, employee.getDepartment());
            if (!(employee.getHrComp().equals(""))) {
                pat.setString(16, employee.getHrComp());
            } else {
                pat.setNull(16, Types.NULL);
            }
            pat.setString(17, employee.getID());
            pat.executeUpdate();

            // always close the connection 
            pat.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override

    public ArrayList<String> get_employee_Skills(String id) {

        //ArrayList<Employee_Data> Employee_Skills = new ArrayList<>();
        
        ArrayList<String> e_Skills = new ArrayList<>();
        Connection con;
        ResultSet rs;
        try {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM skills WHERE skills.emp_id= '" + id+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
           // emp.setID(rs.getString("emp_id"));
            while (rs.next()) {
                e_Skills.add(rs.getString("Skill"));
            }
           // emp.setSkills(e_Skills);
            //Employee_Skills.add(emp);
            st.close();
        } catch (SQLException sqle) {
            System.out.println("Sql Exception :" + sqle.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e_Skills;
    }

    public boolean updateHRTypes(HR_Employee_Data employee) {
        // update the types of hr
        return true;
    }

}
