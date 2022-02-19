/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
public class CashAdvance_Data {

    private String empName, empID, date, amount,reason;

    //ArrayList<String> Skills = new ArrayList<>();
    public CashAdvance_Data(String date_p,String emp_id,String emp_name,String amout_p,String reason_p) {
        empName = emp_name;
        empID = emp_id;
        date = date_p;
        amount = amout_p;
        reason = reason_p;
    }

    public CashAdvance_Data() {
    }

    public void setEmployeeID(String emp_id) {
        empID = emp_id;
    }

    public String getEmployeeID() {
        return empID;
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

    public void setAmount(String amount_p) {
        amount = amount_p;
    }

    public String getAmount() {
        return amount;
    }
    
    public void setReason(String reason_P) {
        reason = reason_P;
    }

    public String getReason() {
        return reason;
    }

}
