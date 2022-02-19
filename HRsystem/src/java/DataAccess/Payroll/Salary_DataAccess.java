/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Payroll;

import Algorithms.Payroll.Salary;
import DataAccess.DatabaseConnection;
import Entity.CashAdvance_Data;
import Entity.Deductions_Data;
import Entity.Salary_Data;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salary_DataAccess implements Salary_interface {

    @Override
    public ArrayList<Salary_Data> Get_Salary_Data(String search) throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1 = null, pat2 = null;
        ResultSet rs = null;
        ArrayList<Salary_Data> D = new ArrayList<>();

        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query, query1, queryCombinedSalary;

            if (search != null) {
                query = "SELECT salary.salaryID,employee.id,employee.first_name,salary.gross,COALESCE(deductions.amount,'0') AS deductions , COALESCE(cashadvance.amount,'0') AS cashAdv,salary.netPay FROM employee JOIN salary ON employee.id= salary.emp_id JOIN deductions ON deductions.emp_id = employee.id JOIN cashadvance ON cashadvance.emp_id = employee.id where salary.empName like '%" + search + "%' or salary.emp_id like '%" + search + "%' ORDER BY employee.id ASC";
            } else {

                query = "SELECT salary.salaryID,employee.id,employee.first_name,salary.gross,COALESCE(deductions.amount,0) As deductions , COALESCE(cashadvance.amount,0) AS cashAdv,salary.netPay FROM employee JOIN salary ON employee.id= salary.emp_id JOIN deductions ON deductions.emp_id = employee.id JOIN cashadvance ON cashadvance.emp_id = employee.id ORDER BY employee.id ASC";
            }
            pat = con.prepareStatement(query);
            rs = pat.executeQuery();
            while (rs.next()) {
                Salary_Data salary;
                System.out.println("employee.salary: " + rs.getString("salary.gross"));
                salary = new Salary_Data(rs.getString("salary.salaryID"),
                        rs.getString("employee.id"), rs.getString("salary.gross"),
                        rs.getString("deductions"), rs.getString("cashAdv"), rs.getString("salary.netPay"), rs.getString("employee.first_name"), "");
              
                String salaryID = rs.getString("salary.salaryID");
                String employeeID = rs.getString("employee.id");
                String grossString = rs.getString("salary.gross");
                String deductionsString = rs.getString("deductions");
                String cashString = rs.getString("cashAdv");
                String employeeName = rs.getString("employee.first_name");
                String netpayString = rs.getString("salary.netPay");
              

                //---------
                System.out.println("grosss: " + grossString);
                System.out.println("GET grosss: " + rs.getString("salary.gross"));

                int gross = Integer.parseInt(grossString);
                System.out.println("first grosss: " + gross);

                int deductions = Integer.parseInt(deductionsString);
                int cash = Integer.parseInt(cashString);
                //int total = gross - deductions + cash;
                int total = Salary.calculateNetpay(gross, deductions, cash);
                //System.out.println("totaaal:"+total);

                query1 = "UPDATE salary SET netPay=? WHERE salaryID=?";

                queryCombinedSalary = "UPDATE combinedSalary SET employeeName = ?,salaryGross = ?,deductions = ?,cashAdv = ?,salaryNetpay =? WHERE employeeID = ?";

                pat1 = con.prepareStatement(query1);
                //out.println("total: "+total);
                pat1.setInt(1, total);
                //out.println("salaryID: "+salaryID);
                pat1.setString(2, salaryID);
                pat1.executeUpdate();
                //------------------------------------
                pat2 = con.prepareStatement(queryCombinedSalary);

                pat2.setString(1, employeeName);
                pat2.setString(2, grossString);
                pat2.setString(3, deductionsString);
                pat2.setString(4, cashString);
                pat2.setString(5, netpayString);
                pat2.setString(6, employeeID);
                // pat2.setString(7, salaryID);
                pat2.executeUpdate();

                D.add(salary);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Salary_DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        pat.close();
        pat1.close();
        pat2.close();
        con.close();
        return D;
    }

    @Override
    public ArrayList<Deductions_Data> Get_Deductions_Data(String search) throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        ArrayList<Deductions_Data> D = new ArrayList<>();
        try {

            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query;

            if (search != null) {
                query = "SELECT employee.first_name,COALESCE(deductions.date,'') AS date,deductions.emp_id,COALESCE(deductions.description,'none') AS description,COALESCE(deductions.amount,'0') AS amount FROM employee JOIN deductions ON employee.id= deductions.emp_id where empName like '%" + search + "%' or emp_id like '%" + search + "%'";
            } else {
                query = "SELECT employee.first_name,COALESCE(deductions.date,'') AS date,deductions.emp_id,COALESCE(deductions.description,'none') AS description,COALESCE(deductions.amount,'0') AS amount FROM employee JOIN deductions ON employee.id= deductions.emp_id ORDER BY deductions.emp_id ASC";
            }

            pat = con.prepareStatement(query);
            rs = pat.executeQuery();

            while (rs.next()) {
                Deductions_Data deduction;
                deduction = new Deductions_Data(rs.getString("first_name"), rs.getString("emp_id"),
                        rs.getString("description"), rs.getString("amount"), rs.getString("date"));

                D.add(deduction);
            }
        } catch (Exception ex) {

            ex.printStackTrace();

        }
        pat.close();
        con.close();
        return D;
    }

    @Override
    public ArrayList<CashAdvance_Data> Get_CashAdvance_Data(String search) throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        ArrayList<CashAdvance_Data> D = new ArrayList<>();
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query;
            if (search != null) {
                query = "SELECT COALESCE(cashadvance.date,'') AS date,COALESCE(cashadvance.description,'none') As description,cashadvance.emp_id,employee.first_name,COALESCE(cashadvance.amount,'0') AS amount FROM employee JOIN cashadvance ON employee.id= cashadvance.emp_id where empName like '%" + search + "%' or emp_id like '%" + search + "%'";
            } else {

                query = "SELECT COALESCE(cashadvance.date,'') AS date,COALESCE(cashadvance.description,'none') As description,cashadvance.emp_id,employee.first_name,COALESCE(cashadvance.amount,'0') AS amount FROM employee JOIN cashadvance ON employee.id= cashadvance.emp_id ORDER BY cashadvance.emp_id ASC";

            }
            pat = con.prepareStatement(query);
            rs = pat.executeQuery();

            while (rs.next()) {
                CashAdvance_Data cashadvance;
                cashadvance = new CashAdvance_Data(rs.getString("date"), rs.getString("emp_id"),
                        rs.getString("first_name"), rs.getString("amount"), rs.getString("description"));

                D.add(cashadvance);
            }
        } catch (Exception ex) {

            ex.printStackTrace();

        }
        pat.close();
        con.close();
        return D;
    }

    @Override
    public boolean updateCashAdvance(CashAdvance_Data data) throws Exception {

        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            // out.println("regno:"+regno+"\nfirstnamr: "+ firstname+"\nlastname"+lastname+"\naddress: "+address+"\nusername: "+username+"\npassword: "+password);
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();

            String query = "update cashadvance set date = ?, amount = ? where emp_id = ?";

            pat = con.prepareStatement(query);
            //System.out.println(query);
            pat.setString(1, data.getDate());
            pat.setString(2, data.getAmount());
            pat.setString(3, data.getEmployeeID());

            pat.executeUpdate();
            pat.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateDeductions(Deductions_Data data) throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query = "update deductions set description = ?, amount = ? where emp_id = ?";

            pat = con.prepareStatement(query);
            //System.out.println(query);
            pat.setString(1, data.getDescription());
            pat.setString(2, data.getAmount());
            pat.setString(3, data.getEmployeeID());
            pat.executeUpdate();

            pat.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateSalary(Salary_Data data) throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query = "update salary set gross = ?, netPay = ? where emp_id = ?";

            pat = con.prepareStatement(query);
            //System.out.println(query);
            pat.setString(1, data.getGross());
            pat.setString(2, data.getNetPay());
            pat.setString(3, data.getEmployeeID());
            pat.executeUpdate();
            pat.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteCash(String id) throws Exception {
        Connection con = null;
        PreparedStatement pat = null;
        try {

            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            //System.out.println("iddddd: " + id);
            //String query = "delete from cashadvance where emp_id = ?";
            String query = "update cashadvance set date = ?, amount = ? where emp_id = ?";
            pat = con.prepareStatement(query);
            pat.setString(1, "None");
            pat.setString(2, "0");
            pat.setString(3, id);
            pat.executeUpdate();
            pat.close();
            con.close();
            return true;

        } catch (Exception e) {
            System.out.println("ex: " + e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDeductions(String id) throws Exception {
        try {
            Connection con;
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            //String query = "delete from deductions where emp_id = ?";
            String query = "update deductions set description = ?, amount = ? where emp_id = ?";
            PreparedStatement pat = con.prepareStatement(query);
            pat.setString(1, "None");
            pat.setString(2, "0");
            pat.setString(3, id);
            pat.executeUpdate();
            pat.close();
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteSalary(String id) throws Exception {
        try {
            Connection con;
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            PreparedStatement pat, pat1, pat2;
            String query = "delete from salary where emp_id = ?";
            pat = con.prepareStatement(query);
            pat.setString(1, id);
            pat.executeUpdate();
            //----------------------------
            String query1 = "delete from cashadvance where emp_id = ?";
            pat1 = con.prepareStatement(query1);
            pat1.setString(1, id);
            pat1.executeUpdate();
            //-----------------------------
            String query2 = "delete from deductions where emp_id = ?";
            pat2 = con.prepareStatement(query2);
            pat2.setString(1, id);
            pat2.executeUpdate();
            //------------------------------
            pat.close();
            pat1.close();
            pat2.close();
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // @Override
    /* public CashAdvance_Data selectForCashUpdate(String id) throws Exception {
        Connection con;
        PreparedStatement pat = null;
        ResultSet rs;
        dbconnection db = new dbconnection();
        con = db.getConnection();
        ArrayList<CashAdvance_Data> D = new ArrayList<>();
        CashAdvance_Data cashadvance = null;
        try {
            pat = con.prepareStatement("select * from cashadvance where emp_id = ?");
            pat.setString(1, id);
            rs = pat.executeQuery();

            while (rs.next()) {
                cashadvance = new CashAdvance_Data(rs.getString("date"), rs.getString("emp_id"),
                        "", rs.getString("amount"));

                D.add(cashadvance);
            }
        } catch (Exception ex) {

            ex.printStackTrace();

        }

        pat.close();

        con.close();
        return cashadvance;

    }*/
    @Override
    public boolean addMonthlySalary(Salary_Data data) throws Exception {
        Connection con;
        PreparedStatement pat = null;
        ResultSet rs;
        DatabaseConnection db = new DatabaseConnection();
        con = db.getConnection();
        try {
            String query = "INSERT INTO salaryhistory(amount,date,empID) VALUES (?,?,?)";
            pat = con.prepareStatement(query);
            //System.out.println(query);
            pat.setString(1, data.getGross());
            pat.setString(2, data.getDate());
            pat.setString(3, data.getEmployeeID());
            pat.executeUpdate();
            pat.close();

            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateMonthlySalary() throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            //set gross in table employee
            String query = "UPDATE employee set salary = (SELECT salaryhistory.amount from salaryhistory where employee.id= salaryhistory.empID and date = (SELECT max(date) from salaryhistory where empID = employee.id))";
            pat = con.prepareStatement(query);
            pat.executeUpdate();
            //set gross in table salary
            String query1 = "UPDATE salary set gross = (SELECT amount from salaryhistory where salary.emp_id= salaryhistory.empID and date = (SELECT max(date) from salaryhistory where empID = salary.emp_id))";
            pat1 = con.prepareStatement(query1);
            pat1.executeUpdate();

            pat.close();
            pat1.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateMonthlyDeduction() throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            //set deduction in table deductions
            String query = "UPDATE deductions set amount = (SELECT deductionshistory.deductionAmount from deductionshistory where deductions.emp_id= deductionshistory.empID and date = (SELECT max(date) from deductionshistory where empID = deductions.emp_id))";
            pat = con.prepareStatement(query);
            pat.executeUpdate();
            //set description in table deductions
            String query1 = "UPDATE deductions set description = (SELECT deductionshistory.reason from deductionshistory where deductions.emp_id= deductionshistory.empID and date = (SELECT max(date) from deductionshistory where empID = deductions.emp_id))";
            pat1 = con.prepareStatement(query1);
            pat1.executeUpdate();
            //set date in table deductions
            String query2 = "UPDATE deductions set date = (SELECT deductionshistory.date from deductionshistory where deductions.emp_id= deductionshistory.empID and date = (SELECT max(date) from deductionshistory where empID = deductions.emp_id))";
            pat2 = con.prepareStatement(query2);
            pat2.executeUpdate();
            pat.close();
            pat1.close();
            pat2.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateMonthlyCash() throws Exception {
        Connection con = null;
        PreparedStatement pat = null, pat1, pat2;
        ResultSet rs = null;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            //set deduction in table deductions
            String query = "UPDATE cashadvance set amount = (SELECT rewardhistory.rewardAmount from rewardhistory where cashadvance.emp_id= rewardhistory.empID and date = (SELECT max(date) from rewardhistory where empID = cashadvance.emp_id))";
            pat = con.prepareStatement(query);
            pat.executeUpdate();
            //set description in table deductions
            String query1 = "UPDATE cashadvance set date = (SELECT rewardhistory.date from rewardhistory where cashadvance.emp_id= rewardhistory.empID and date = (SELECT max(date) from rewardhistory where empID = cashadvance.emp_id))";
            pat1 = con.prepareStatement(query1);
            pat1.executeUpdate();
            String query2 = "UPDATE cashadvance set description = (SELECT rewardhistory.reason from rewardhistory where cashadvance.emp_id= rewardhistory.empID and date = (SELECT max(date) from rewardhistory where empID = cashadvance.emp_id))";
            pat2 = con.prepareStatement(query2);
            pat2.executeUpdate();
            pat.close();
            pat1.close();
            pat2.close();
            con.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
