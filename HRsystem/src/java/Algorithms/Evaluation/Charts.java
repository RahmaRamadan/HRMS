/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Evaluation;

//import com.sun.javafx.collections.MappingChange.Map;
import DataAccess.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.sun.javafx.collections.MappingChange.Map;

/**
 *
 * @author Zak
 */
public class Charts 
{
 
    public int getNumofEmployees(int ID) throws ClassNotFoundException, SQLException, Exception
    {
        int Counter = 0 ;
        Connection con;
        ResultSet rs;
        con = DatabaseConnection.getConnection();
        
        String query = " SELECT trainingID , COUNT(trainingID) as genderCount FROM employee WHERE trainingID="+ ID +" GROUP BY trainingID";

        Statement st = con.createStatement();
        rs = st.executeQuery(query);
        //Counter = rs.getInt(2); 
      
      
      while(rs.next())
      {
         Counter = rs.getInt("genderCount");  
         // Counter++;
      }
      //System.out.println("counter: " + Counter);
      return Counter;
    }
    
    
    public List<Map<Object, Object>>  getGenderDistribution(int trainingID) throws SQLException, ClassNotFoundException, Exception 
    {
        int num = getNumofEmployees(trainingID) ;
        List<Map<Object, Object>>  genderCount = new ArrayList<Map<Object, Object>> ();

        Connection con;
        ResultSet rs;
        con = DatabaseConnection.getConnection();
        String query = "SELECT gender, COUNT(gender) FROM employee WHERE trainingID=" + trainingID + " GROUP BY gender;";

        Statement st = con.createStatement();
        rs = st.executeQuery(query);
       
        while (rs.next())
        {
            //HashMap<Object, Object>  map = new HashMap<Object, Object>();
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.put("label",rs.getString(1));
            map.put("y",rs.getInt(2)*100.0/num);
            genderCount.add((Map<Object, Object>) map);
        }
        st.close();
        
        return genderCount;
    }
    
    
    public List<Map<Object, Object>> employee_Scores(int id) throws SQLException, ClassNotFoundException, Exception   
   {
       
       List<Map<Object, Object>>  Emp_Scores = new ArrayList<Map<Object, Object>> ();
       Connection con;
       ResultSet rs;
        try
        {
            con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM score WHERE score.employee_ID="+ id ;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next())
            {
                Map<Object, Object>  map = new HashMap<Object, Object>();
                map.put("label",rs.getString("date"));
                map.put("y",rs.getInt("score"));
                Emp_Scores.add((Map<Object, Object>) map);
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
        }
        
       return Emp_Scores;
   }
    
    
    
    public List<Map<Object, Object>>  traningsChart() throws SQLException, ClassNotFoundException, Exception 
    {
        List<Map<Object, Object>>  trainingsData = new ArrayList<Map<Object, Object>> ();

        Connection con;
        ResultSet rs;
        con = DatabaseConnection.getConnection();
        String query = "SELECT Name, Start_Date , End_Date FROM training ";

        Statement st = con.createStatement();
        rs = st.executeQuery(query);
       
        while (rs.next())
        {
            //HashMap<Object, Object>  map = new HashMap<Object, Object>();
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.put("label",rs.getString("Name"));
            map.put("y",new String[] {"Start_Date","End_Date"});
            trainingsData.add((Map<Object, Object>) map);
        }
        st.close();
        
        return trainingsData;
    }
    
    /* String Employee_id =  request.getParameter("myUL");
            int id ;
            id = Integer.parseInt(Employee_id);
            Data_Access_Implementation a = new Data_Access_Implementation();
            ArrayList<Employee> emp = a.employee_Scores(id);*/
}
