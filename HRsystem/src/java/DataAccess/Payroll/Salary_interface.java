/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Payroll;

import Entity.CashAdvance_Data;
import Entity.Deductions_Data;
import Entity.Salary_Data;
import java.util.ArrayList;

/**
 *
 * @author egypt2
 */
public interface Salary_interface {

    public ArrayList<Salary_Data> Get_Salary_Data(String query) throws Exception;

    public ArrayList<Deductions_Data> Get_Deductions_Data(String query) throws Exception;

    public ArrayList<CashAdvance_Data> Get_CashAdvance_Data(String query) throws Exception;

    public boolean updateSalary(Salary_Data data) throws Exception;

    public boolean updateCashAdvance(CashAdvance_Data data) throws Exception;

    public boolean updateDeductions(Deductions_Data data) throws Exception;

    public boolean deleteCash(String id) throws Exception;

    public boolean deleteDeductions(String id) throws Exception;

    public boolean deleteSalary(String id) throws Exception;
    
    public boolean addMonthlySalary(Salary_Data data) throws Exception;
    
    public boolean updateMonthlySalary() throws Exception;
    
    public boolean updateMonthlyDeduction() throws Exception;
    
    public boolean updateMonthlyCash() throws Exception;

    //public CashAdvance_Data selectForCashUpdate(String id) throws Exception;

}
