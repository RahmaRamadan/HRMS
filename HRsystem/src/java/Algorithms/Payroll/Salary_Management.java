/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Payroll;

import DataAccess.EmployeesAffairs.Employee_Salary_Interface;
import DataAccess.EmployeesAffairs.MySQL_Salary_DataAccess;
import DataAccess.Payroll.Salary_DataAccess;
import DataAccess.Payroll.Salary_interface;
import Entity.CashAdvance_Data;
import Entity.Deductions_Data;
import Entity.Salary_Data;
import Entity.dedOrReward_Data;
import java.util.ArrayList;


/**
 *
 * @author dell
 */
public class Salary_Management {

    public ArrayList<Salary_Data> Get_Salary_Data(String query) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.Get_Salary_Data(query);
    }

    public ArrayList<Deductions_Data> Get_Deductions_Data(String query) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.Get_Deductions_Data(query);
    }

    public ArrayList<CashAdvance_Data> Get_CashAdvance_Data(String query) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.Get_CashAdvance_Data(query);
    }

    public boolean updateCashAdvance(CashAdvance_Data data) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateCashAdvance(data);

    }

    public boolean updateDeductions(Deductions_Data data) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateDeductions(data);

    }

    public boolean updateSalary(Salary_Data data) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateSalary(data);

    }

    public boolean deleteCash(String id) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.deleteCash(id);
    }

    public boolean deleteDeductions(String id) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.deleteDeductions(id);
    }

    public boolean deleteSalary(String id) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.deleteSalary(id);
    }

    public boolean addMonthlySalary(Salary_Data data) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.addMonthlySalary(data);

    }

    public boolean updateMonthlySalary() throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateMonthlySalary();

    }

    public boolean updateMonthlyDeduction() throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateMonthlyDeduction();

    }

    public boolean updateMonthlyCash() throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.updateMonthlyCash();

    }
      public boolean manageDed_Reward(dedOrReward_Data sal) throws Exception
    {
        Employee_Salary_Interface salDataAccess = new MySQL_Salary_DataAccess();
        // 
        return salDataAccess.manageDedOrRew(sal);
    }


    /*public CashAdvance_Data selectForCashUpdate(String id) throws Exception {
        Salary_interface salaryDataAccess = new Salary_DataAccess();
        return salaryDataAccess.selectForCashUpdate(id);
    }*/
}
