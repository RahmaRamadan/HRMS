/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Application.Recruitment.Recruitment;
//import Application.Payroll.Payrolls;
import Application.TimeTracking.Time_Tracking;
import Application.Evaluation.Evaluation;
import Application.EmployeesAffairs.Employees_Affairs;
import Entity.HR_Employee_Data;
import Entity.HR_Type;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class HR_Employee {

    HR_Employee_Data employeeData;
    private ArrayList<HR_Component> components;
    // my attendence manager
    // view salary my manager
    // ....
    

    HR_Employee(HR_Employee_Data hed) {

        employeeData = hed;
        for (int i = 0; i < hed.getTypes().size(); i++) {
            if (hed.getTypes().get(i).toString().equals("Recruitment")) {
                components.add(new Recruitment());
            } else if (hed.getTypes().get(i).toString().equals("Evaluation")) {
                components.add(new Evaluation());
            } else if (hed.getTypes().get(i).toString().equals("Time_Tracking")) {
                components.add(new Time_Tracking());
            } else if (hed.getTypes().get(i).toString().equals("Payroll")) {
                //components.add(new Payrolls());
            } else if (hed.getTypes().get(i).toString().equals("Employees_Affairs")) {
                components.add(new Employees_Affairs());
            }
            // manager 
            else{
             //   empty the arraylist then add the 4 components to it then break;
                
            }
        }
    

    }

}
