package DataAccess.Evaluation;


import DataAccess.DatabaseConnection;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.text.SimpleDateFormat;    
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataAccess.Evaluation.Training_Data_Access_Interface;
import Entity.Employee_Data;
import Entity.Training;
import Entity.Training_Acceptance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 * @author Zak
 */
public class Training_Data_Access implements Training_Data_Access_Interface
{
    @Override
    public ArrayList<Training> Get_Trainings_Data() 
    {
        
        ArrayList<Training> T = new ArrayList<>();
        Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM training";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
            {
                Training training = new Training();    
                training.setID(rs.getInt("ID"));
                training.setName(rs.getString("Name"));
                training.setStart_Date(rs.getString("Start_Date")) ;
                training.setEnd_Date(rs.getString("End_Date")); 
                training.setDescription(rs.getString("Description"));
                training.setScore(rs.getInt("Score")); 
                T.add(training);
                System.out.format("%s, %s, %s, %s, %s , %s\n", training.getID(), training.getName(), training.getStart_Date(), training.getEnd_Date(), training.getDescription(), training.getScore());
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
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return T ; 
        
    }  

   @Override
    public boolean setTraining(Training t)
    {
        Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = " insert into training (ID, Name,Start_Date,End_date, Description, Score)"
             + " values (?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, t.getID());
            preparedStmt.setString (2, t.getName());
            preparedStmt.setString(3, t.getStart_Date());
            preparedStmt.setString(4, t.getEnd_Date());
            preparedStmt.setString (5, t.getDescription());
            preparedStmt.setInt(6, t.getScore());
            preparedStmt.execute();
            
            String query2 = " insert into training_skills (t_id,t_skill)"
             + " values (?, ?)";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            for(int i = 0 ; i < t.getSkills().size() ; i++)
            {
               preparedStmt2.setInt(1, t.getID());
               preparedStmt2.setString (2, t.getSkills().get(i));
               preparedStmt2.execute();
            }
            
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
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
  }
    
    @Override
    public boolean deleteTraining(int trainingID)
    {
        Connection con;
        ResultSet rs;
        try {
            con = DatabaseConnection.getConnection();
            String query = "delete from training where id = ?";
            PreparedStatement pat = con.prepareStatement(query);
            pat.setInt(1, trainingID);
            pat.executeUpdate();
            
            String query2 = "delete from training_skills where id = ?";
            PreparedStatement pat2 = con.prepareStatement(query2);
            pat2.setInt(1, trainingID);
            pat2.executeUpdate();
            
            pat.close();
            pat2.close();
            con.close();
            return true;

        } catch (Exception e) {

            return false;
        }
        
    }
    
    
    @Override
  public ArrayList<String> get_training_Skills(int id) {
        //ArrayList<Training> Training_Skills = new ArrayList<>();
        ArrayList<String> t_skills = new ArrayList<>();
        Connection con;
        ResultSet rs;
        
        int i = 0;
        try {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM training_skills WHERE training_skills.t_id=" + id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            //int t_id = rs.getInt("t_id");
         
            while (rs.next()) 
            {
                t_skills.add(rs.getString("t_skill"));
            }
           
           
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t_skills;
    }
  
  public boolean insert_trainScore(String emp_id , int t_id , double s)
  {
        Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = " insert into training_list (training_id, employee_id,training_score)"
             + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, t_id);
            preparedStmt.setString (2, emp_id);
            preparedStmt.setDouble(3, s);
            
            preparedStmt.execute();
            
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
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
  }
  
  @Override
   public ArrayList<Training_Acceptance> getAcceptedEmployees(int t_id)
   {
       ArrayList<Training_Acceptance> employees = new ArrayList<>();
       
        
       Connection con;
        ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM training_list where training_id= "+ t_id +" ORDER BY training_score DESC";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
            {
                Training_Acceptance training = new Training_Acceptance();
                training.setTrainingID(rs.getInt("training_id"));
                training.setEmployeeID(rs.getString("employee_id"));
                training.setScore(rs.getDouble("training_score")); 
                employees.add(training);
                System.out.format("%s, %s,%s\n", training.getTrainingID(), training.getEmployeeID(), training.getScore());
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
            Logger.getLogger(Training_Data_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return employees;
   }
   
  /* public static void main(String[] args) throws Exception {
        // TODO code application logic here
      ArrayList<Training_Acceptance> s = new ArrayList<>();
              s = getAcceptedEmployees(1);
              for (int i = 0; i < s.size(); i++){
                  System.out.println(s.get(i).getEmployeeID() + "   " + s.get(i).getTrainingID() + "   " + s.get(i).getScore());
              }
    }*/
}

  
