/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

/**
 *
 * @author maria
 */

public interface Employee_Attendance_Interface {
    boolean validateLogin(String id, String Password, String uname) throws Exception;
    boolean checkAttendance (String date) throws Exception;
}