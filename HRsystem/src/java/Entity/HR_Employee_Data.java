/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class HR_Employee_Data extends Employee_Data {
    
    private boolean isManager;
    private ArrayList<HR_Type> types ; 
    
    // setter and getter and constructor

    public HR_Employee_Data(String id, String fname, String lname,String gen, String user_name, String pass, String add, String salar, String title_, String nVacations_,
            String hiring_Date, String age_, String empType, String departID, String dep, String comp) {
        super(id, fname, lname, gen, user_name, pass, add, salar, title_, nVacations_, hiring_Date, age_,empType, departID, dep, comp);
    
    }
    public void setTypes(ArrayList<HR_Type> types_)
    {
        types = types_;
    }
      public void setTypes(boolean isManage)
    {
       isManager  = isManage;
    }   
    public  ArrayList<HR_Type> getTypes()
    {
        return types;
    }
    
}
