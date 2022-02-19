/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

//import Entity.Monthly_Salary;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface HR_Salary_Interface {
       // public ArrayList<Monthly_Salary> getSalariesHistory(String empID);
      //  public boolean insertSalary(Monthly_Salary salary);
        public boolean updateBasicSalary(); // update the basic salary
        public boolean updateNetPay(double addAmount, double oldNetPay, String modificationReason, int salaryID); // reward ot deduction
    
}
