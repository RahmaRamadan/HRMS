/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author egypt2
 */
public class Deductions_Data {

    private String empName, empID, description, amount,date;

    //ArrayList<String> Skills = new ArrayList<>();
    public Deductions_Data(String emp_name, String emp_id, String descrip_p, String amout_p, String date_p) {
        empName = emp_name;
        empID = emp_id;
        description = descrip_p;
        amount = amout_p;
        date = date_p;
        
    }

    public Deductions_Data() {
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

    public void setDescription(String descrip_p) {
        description = descrip_p;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(String amount_p) {
        amount = amount_p;
    }

    public String getAmount() {
        return amount;
    }
    
    public void setDate(String date_p) {
        date = date_p;
    }

    public String getDate() {
        return date;
    }

}
