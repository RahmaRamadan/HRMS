/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class Salary_Data {

    private String salaryID, empID, gross, deductions, cashAdv, netPay;
    private String empName, date;
    //ArrayList<String> Skills = new ArrayList<>();

    public Salary_Data(String salary_id, String emp_id, String gross_p,
            String deductions_p, String cashadv_p, String netpay_p, String emp_name, String date_p) {
        salaryID = salary_id;
        empID = emp_id;
        gross = gross_p;
        deductions = deductions_p;
        cashAdv = cashadv_p;
        netPay = netpay_p;
        empName = emp_name;
        date = date_p;
    }

    public Salary_Data() {
    }

    public void setSalaryID(String salary_id) {
        salaryID = salary_id;
    }

    public String getSalaryID() {
        return salaryID;
    }

    public void setEmployeeID(String emp_id) {
        empID = emp_id;
    }

    public String getEmployeeID() {
        return empID;
    }

    public void setGross(String gross_p) {
        gross = gross_p;
    }

    public String getGross() {
        return gross;
    }

    public void setDeductions(String deduction_p) {
        deductions = deduction_p;
    }

    public String getDeductions() {
        return deductions;
    }

    public void setCashAdvd(String cashAdv_p) {
        cashAdv = cashAdv_p;
    }

    public String getCashAdv() {
        return cashAdv;
    }

    public void setNetPay(String netpay_p) {
        netPay = netpay_p;
    }

    public String getNetPay() {
        return netPay;
    }

    public void setEmployeeName(String emp_name) {
        empName = emp_name;
    }

    public String getEmployeeName() {
        return empName;
    }

    public void setDate(String date_p) {
        date = date_p;
    }

    public String getDate() {
        return date;
    }

}
