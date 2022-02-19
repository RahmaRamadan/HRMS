/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.EmployeesAffairs;

import Algorithms.EmployeesAffairs.Employee_Management;
import Algorithms.Payroll.Salary_Management;
import Algorithms.EmployeesAffairs.Vacation_Management;
import Application.HR_Component;
import DataAccess.EmployeesAffairs.Employee_DataAccess_Interface;
import DataAccess.EmployeesAffairs.MySQL_Employee_DataAccess;
import Entity.Employee_Data;
import Entity.Vacation_Data;
import Entity.dedOrReward_Data;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Employees_Affairs extends HR_Component  {
    // write all use case functions here and let other algorithms classes implement it
    public boolean addEmployee(Employee_Data employee) throws Exception{
        Employee_Management em = new Employee_Management();
        return em.addEmployee(employee);
        
    }
    public boolean deleteEmployee(String id) throws Exception {
           Employee_Management em = new Employee_Management();
           return em.deleteEmployee(id);
    }
     public ArrayList<Employee_Data> getEmployees(String query) throws Exception {
            Employee_Management em = new Employee_Management();
            return em.getEmployees(query);
         
     }
     public boolean updateEmployee(Employee_Data employeeData) throws Exception
    {Employee_Management em = new Employee_Management();
      return em.updateEmployee(employeeData);
        
    }
    public boolean checkVacation(Vacation_Data vacData) throws Exception
    {
        // calculate the vacation time        
        Vacation_Management vac = new Vacation_Management();
        return vac.checkVacation(vacData);
    }
    
    public boolean manageDed_rew(dedOrReward_Data salData) throws Exception
    {
        // calculate the vacation time        
        Salary_Management sal = new Salary_Management();
        return sal.manageDed_Reward(salData);
    }
    public boolean loginValidation(String id, String pass, String uname) throws Exception
    {
        Employee_Management log = new Employee_Management();
        return log.Login(id, pass, uname);
    }
     public boolean Attendance(String date) throws Exception
    {
        Employee_Management log = new Employee_Management();
        return log.checkAttend(date);
    }
}
