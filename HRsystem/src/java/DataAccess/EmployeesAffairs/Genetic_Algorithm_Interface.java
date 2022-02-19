/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import Entity.Employee_Data;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Genetic_Algorithm_Interface {
     public ArrayList<Employee_Data> getEmployees(String search) throws Exception;
      public boolean updateEmployee(Employee_Data employee) throws Exception;
         public ArrayList<String> get_employee_Skills(String id);
    
}
