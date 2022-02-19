/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;


//import Entity.Monthly_Salary;;
import Entity.dedOrReward_Data;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Employee_Salary_Interface {
   
  //  public ArrayList<Monthly_Salary> getSalariesHistory(String empID);
    public boolean manageDedOrRew(dedOrReward_Data Salary);
    
}
