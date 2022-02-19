/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.EmployeesAffairs;

import DataAccess.EmployeesAffairs.Employee_Attendance_Interface;
import DataAccess.EmployeesAffairs.Employee_DataAccess_Interface;
import DataAccess.EmployeesAffairs.Employee_Salary_Interface;
import DataAccess.EmployeesAffairs.Employee_Vacation_Interface;
import DataAccess.EmployeesAffairs.MySQL_Attendance_DataAccess;
import DataAccess.EmployeesAffairs.MySQL_Employee_DataAccess;
import DataAccess.EmployeesAffairs.MySQL_Salary_DataAccess;
import DataAccess.EmployeesAffairs.MySQL_Vacation_DataAccess;
import Entity.Employee_Data;
import static Entity.HR_Type.Employees_Affairs;
import Entity.Vacation_Data;
import Entity.dedOrReward_Data;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Employee_Management  {
    public boolean addEmployee(Employee_Data employee) throws Exception
    {
        Employee_DataAccess_Interface empDataAccess = new MySQL_Employee_DataAccess();
        return empDataAccess.insertEmployee(employee);
        
    }
    public boolean deleteEmployee(String id) throws Exception {
          Employee_DataAccess_Interface empDataAccess = new MySQL_Employee_DataAccess();
          return empDataAccess.deleteEmployee(id);
    }
    public ArrayList<Employee_Data> getEmployees(String query) throws Exception {
        Employee_DataAccess_Interface empDataAccess = new MySQL_Employee_DataAccess();
        return empDataAccess.getEmployees(query);
    }
    public boolean updateEmployee(Employee_Data employeeData) throws Exception{
    Employee_DataAccess_Interface empDataAccess = new MySQL_Employee_DataAccess();
      return empDataAccess.updateEmployee(employeeData);
        
    }
    public boolean Login(String id, String pass, String un) throws Exception{
        Employee_Attendance_Interface log = new MySQL_Attendance_DataAccess();
        return log.validateLogin(id, pass, un);
    }
    public boolean checkAttend(String date) throws Exception{
        Employee_Attendance_Interface log = new MySQL_Attendance_DataAccess();
        return log.checkAttendance(date);
    }
   
    
   
    
}
