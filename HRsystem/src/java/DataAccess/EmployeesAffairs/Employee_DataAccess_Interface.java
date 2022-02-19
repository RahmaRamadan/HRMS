/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import Entity.Employee_Data;
import Entity.HR_Employee_Data;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Employee_DataAccess_Interface {
    public boolean insertEmployee(Employee_Data employee)throws Exception;
    public boolean deleteEmployee(String id) throws Exception;
    public ArrayList<Employee_Data> getEmployees(String search ) throws Exception;
     public Employee_Data getEmployeeByID(String id) throws Exception;
      public boolean updateEmployee(Employee_Data employee) throws Exception;
      public ArrayList<String> get_employee_Skills(String id);
      
    
}
