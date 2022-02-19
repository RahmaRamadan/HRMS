/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Evaluation;

import DataAccess.DatabaseConnection;
import Entity.Employee_Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zak
 */
public class Score_Data_access implements Score_Data_Access_Interface
{
  
    @Override
    public ArrayList<Employee_Data> get_employees_scores () 
    {
         ArrayList<Employee_Data> emp = new ArrayList<>();
        Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT employee.id , employee.first_name, employee.last_name , employee.Score FROM employee ORDER BY employee.Score DESC ;";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
            {
                Employee_Data  e = new Employee_Data();
                e.setID(rs.getString("id"));
                e.setFName(rs.getString("first_name"));
                e.setLName(rs.getString("last_name"));
                e.setScore(rs.getInt("Score"));
                emp.add(e);
                System.out.format("%s,%s,%s, %s\n",e.getID() ,e.getFName() , e.getLName(), e.getScore());
            }
            st.close();
        }
        
        catch(SQLException sqle) 
        {
            System.out.println("Sql Exception :"+sqle.getMessage());
        }
        catch(ClassNotFoundException e) 
        {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Score_Data_access.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return emp ; 
    }
    
    @Override
    public ArrayList<Employee_Data> Employee_History_Scores(int id)
   {
          
       ArrayList<Employee_Data> Emp_Scores = new ArrayList<>(); 
       ArrayList<Integer> e_Scores = new ArrayList<>();
       Connection con;
       ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM score WHERE score.employee_ID="+ id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            Employee_Data emp = new Employee_Data(); 
            emp.setID(rs.getString("id"));
            while (rs.next())
            {
                e_Scores.add(rs.getInt("score"));
            }
            emp.setEmployeeScores(e_Scores);
            Emp_Scores.add(emp); 
            st.close();
        }
        
        catch(SQLException sqle) 
        {
            System.out.println("Sql Exception :"+sqle.getMessage());
        }
        catch(ClassNotFoundException e) 
        {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Score_Data_access.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return Emp_Scores;
   }
    @Override
     public boolean updateScore(String id, int score)
     {
         Employee_Data emp= get_employee_score(id);
        Connection con;
        ResultSet rs;
        try
        {
            Date CurrentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(CurrentDate);
            con = DatabaseConnection.getConnection();
             String query = " insert into score (employee_ID,score,date)"
             + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.setInt(2,score );
            preparedStmt.setString(3, dateString);
            preparedStmt.execute();
            
            String query2 = " update employee set Score = ? where id ='"+ id+"'";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            
            preparedStmt2.setInt(1, score+emp.getScore());
            preparedStmt2.execute();
         
            
            con.close();
            return true;
        }
        
        catch(SQLException sqle) 
        {
            System.out.println("Sql Exception :"+sqle.getMessage());
            return false;
        }
        catch(ClassNotFoundException e) 
        {
            System.out.println("Class Not Found Exception :" + e.getMessage());
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Score_Data_access.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
         
     }
     
     public Employee_Data get_employee_score (String id) 
    {
        Employee_Data e = null;
        Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT employee.id , employee.first_name, employee.last_name , employee.Score FROM employee WHERE employee.id='"+id+"' ORDER BY employee.Score DESC ;";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
            {
             
                e.setID(rs.getString("id"));
                e.setFName(rs.getString("first_name"));
                e.setLName(rs.getString("last_name"));
                e.setScore(rs.getInt("Score"));
             
                System.out.format("%s,%s,%s, %s\n",e.getID() ,e.getFName() , e.getLName(), e.getScore());
            }
            st.close();
        }
        
        catch(SQLException sqle) 
        {
            System.out.println("Sql Exception :"+sqle.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Score_Data_access.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e ; 
    }
}
