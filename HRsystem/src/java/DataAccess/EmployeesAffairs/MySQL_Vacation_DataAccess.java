/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import DataAccess.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DataAccess.EmployeesAffairs.Employee_Vacation_Interface;
import Entity.Vacation_Data;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class MySQL_Vacation_DataAccess implements Employee_Vacation_Interface {
 
     private static int vacationDays_dbI2;
     private static float daysBetween2;
     private static Date hiringDatee;
     public void setVacDays(int v){
         vacationDays_dbI2 = v;
     }
      public void SetdaysBetweenn(float days){
         daysBetween2 = days;
     }
      public void SetHiringDate(Date date){
         hiringDatee = date;
          
     }
      
     @Override
    public boolean checkVacation(Vacation_Data vac) {


            Connection con = null;
                PreparedStatement pat, pat2;
                ResultSet rs;
         try {
             con = DatabaseConnection.getConnection();
         } catch (Exception ex) {
             Logger.getLogger(MySQL_Vacation_DataAccess.class.getName()).log(Level.SEVERE, null, ex);
         }
                String query, query2 ="";
                
              
                    query= "select * from employee where id = ?";
               
         try {
             pat = con.prepareStatement(query);
             pat.setString(1, vac.getID());
                rs = pat.executeQuery();
        
                String name = rs.getString("id");
                if(name.equals("")) return false;
                String vacationDays_db;
                int vacationDays_dbI = 0;
                Date hiringDate = new Date();
                String age;
                int ageI = 0;
                while(rs.next()){
                    vacationDays_db =rs.getString("numOfVacations");
                    vacationDays_dbI = Integer.parseInt(vacationDays_db);
                    setVacDays(vacationDays_dbI);
                    
                     hiringDate =rs.getDate("hiring_date");
                     SetHiringDate(hiringDate);
                     age = rs.getString("age");
                     ageI = Integer.parseInt(age);
                    
                }
              
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date curr = new Date(System.currentTimeMillis());
         float daysBetween = 0;

	 try {
	       
	       long difference = curr.getTime() - hiringDate.getTime();
	       daysBetween = (difference / (1000*60*60*24));
               SetdaysBetweenn(daysBetween);
               
	      
	 } catch (Exception e) {
	       e.printStackTrace();
               return false;
	 }
         if(daysBetween >= 3650 || ageI >= 50 )
         {
             query2 = "Update employee set numOfVacations = 30 WHERE id = "+vac.getID();
                try {
                    pat2 = con.prepareStatement(query2);
                    pat2.executeUpdate(query2);
                    pat2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQL_Vacation_DataAccess.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
             
             
         }
         pat.close();
         con.close();
         
         } catch (SQLException ex) {
             Logger.getLogger(MySQL_Vacation_DataAccess.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
      
      
      return true;
    }
    public int getVacDays(){
          return vacationDays_dbI2;
      }
      public float getDaysBetween(){
          return daysBetween2;
      }
      public Date getHiringDate(){
          return hiringDatee;
      }

}
