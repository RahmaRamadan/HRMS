/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.EmployeesAffairs;

import DataAccess.EmployeesAffairs.Employee_Vacation_Interface;
import DataAccess.EmployeesAffairs.MySQL_Vacation_DataAccess;
import Entity.Vacation_Data;

/**
 *
 * @author egypt2
 */
public class Vacation_Management {
     public boolean checkVacation(Vacation_Data vac) throws Exception
    {
        Employee_Vacation_Interface empDataAccess = new MySQL_Vacation_DataAccess();
        // 
        return empDataAccess.checkVacation(vac);
    }
}
