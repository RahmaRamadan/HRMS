/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import DataAccess.DatabaseConnection;
//import Entity.Monthly_Salary;
import Entity.dedOrReward_Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class MySQL_Salary_DataAccess implements Employee_Salary_Interface, HR_Salary_Interface {

    /*    @Override
    public ArrayList<Monthly_Salary> getSalariesHistory(String empID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
 /* @Override
    public boolean insertSalary(Monthly_Salary salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
    @Override
    public boolean updateBasicSalary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateNetPay(double addAmount, double oldNetPay, String modificationReason, int salaryID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean manageDedOrRew(dedOrReward_Data Salary) {
        try {
            Connection con;
            PreparedStatement pat;
            //ResultSet rs = null;

            con = DatabaseConnection.getConnection();

            if (Salary.getType().equals("Reward")) {
                String query = "INSERT INTO rewardhistory(idsalaryReward, rewardAmount,date,reason,empID) VALUES (?,?,?,?,?)";
                pat = con.prepareStatement(query);
                pat.setString(1, Salary.getSalID());
                pat.setString(2, Salary.getAmount());
                pat.setString(3, Salary.getDate());
                pat.setString(4, Salary.getReason());
                pat.setString(5, Salary.getID());
                pat.executeUpdate();
                
                pat.close();
                con.close();
                return true;
            } else {
                String query = "INSERT INTO deductionshistory(idsalarydeduction, deductionAmount,date,reason,empID) VALUES (?,?,?,?,?)";
                pat = con.prepareStatement(query);
                pat.setString(1, Salary.getSalID());
                pat.setString(2, Salary.getAmount());
                pat.setString(3, Salary.getDate());
                pat.setString(4, Salary.getReason());
                pat.setString(5, Salary.getID());
                pat.executeUpdate();
                pat.close();
                con.close();
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

}
