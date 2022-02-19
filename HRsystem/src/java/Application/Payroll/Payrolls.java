/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Payroll;

import Algorithms.Payroll.Salary_Management;
import Application.HR_Component;
import Entity.CashAdvance_Data;
import Entity.Deductions_Data;
import Entity.Salary_Data;
import java.util.ArrayList;



/**
 *
 * @author dell
 */
public class Payrolls extends HR_Component {

    public ArrayList<Salary_Data> Get_Salary_Data(String query) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.Get_Salary_Data(query);

    }

    public ArrayList<Deductions_Data> Get_Deductions_Data(String query) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.Get_Deductions_Data(query);

    }

    public ArrayList<CashAdvance_Data> Get_CashAdvance_Data(String query) throws Exception {
        Salary_Management sm = new Salary_Management();
        System.out.println("searrrrch: " + query);
        return sm.Get_CashAdvance_Data(query);

    }

    public boolean updateCashAdvance(CashAdvance_Data data) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateCashAdvance(data);

    }

    public boolean updateDeductions(Deductions_Data data) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateDeductions(data);

    }

    public boolean updateSalary(Salary_Data data) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateSalary(data);
    }

    public boolean deleteCash(String id) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.deleteCash(id);
    }

    public boolean deleteDeductions(String id) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.deleteDeductions(id);
    }

    public boolean deleteSalary(String id) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.deleteSalary(id);
    }

    public boolean addMonthlySalary(Salary_Data data) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.addMonthlySalary(data);

    }
    
    public boolean updateMonthlySalary() throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateMonthlySalary();
    }
    public boolean updateMonthlyDeduction() throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateMonthlyDeduction();
    }
    public boolean updateMonthlyCash() throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.updateMonthlyCash();
    }

    /*public CashAdvance_Data selectForCashUpdate(String id) throws Exception {
        Salary_Management sm = new Salary_Management();
        return sm.selectForCashUpdate(id);

    }*/
}
