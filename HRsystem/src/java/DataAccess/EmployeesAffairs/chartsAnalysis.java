/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import DataAccess.DatabaseConnection;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
/**
 *
 * @author egypt2
 */
public class chartsAnalysis {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.javafx.collections.MappingChange.Map;

    public int getNumofEmployees() throws Exception ,ClassNotFoundException, SQLException
    {
        
        int Counter = 0 ;
        Connection con;
        ResultSet rs;
        
        con = DatabaseConnection.getConnection();
        
        String query = "SELECT COUNT(*) as genderCount FROM employee";

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

    
    public List<Map<Object, Object>>  getGenderDistribution() throws SQLException, ClassNotFoundException, Exception 
    {
        int num = getNumofEmployees() ;
        List<Map<Object, Object>>  genderCount = new ArrayList<Map<Object, Object>> ();

        Connection con;
        ResultSet rs;
        con = DatabaseConnection.getConnection();
        String query = "SELECT gender,COUNT(gender) FROM employee GROUP BY gender;";

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
    
//--------------------------------------------------------------------------------------------
    
    public int getNumofAtten() throws Exception ,ClassNotFoundException, SQLException
    {
        
        int Counter = 0 ;
        Connection con;
        ResultSet rs;
        
        con = DatabaseConnection.getConnection();
        
        String query = "SELECT COUNT(*) as attendCount FROM attendance";

        Statement st = con.createStatement();
        rs = st.executeQuery(query);
        //Counter = rs.getInt(2); 
      
      
      while(rs.next())
      {
         Counter = rs.getInt("attendCount");  
         // Counter++;
      }
      //System.out.println("counter: " + Counter);
      return Counter;
}
    
public List<Map<Object, Object>>  generalAttendance() throws SQLException, ClassNotFoundException, Exception 
    {
        int num = getNumofAtten();
        List<Map<Object, Object>>  genderCount = new ArrayList<Map<Object, Object>> ();

        Connection con;
        ResultSet rs;
        con = DatabaseConnection.getConnection();
        String query = "SELECT status,COUNT(status) FROM attendance GROUP BY status;";

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
//----------------------------------------------------------------------------------------------

public int daysOfMonth( int year, int month){
    YearMonth yearMonthObject = YearMonth.of(1999, 2);
int daysInMonth = yearMonthObject.lengthOfMonth();
return daysInMonth;
}

public int countWorkDays(int year, int month) throws Exception {
    int workingDays = 0;
    int monthDays = daysOfMonth(year,month);
    String startDate = "01/07/2021"; //"1"+"/"+ Integer.toString(month)+"/" + Integer.toString(year);
    String endDate = "30/07/2021";//Integer.toString(monthDays)+"/" +"0"+ Integer.toString(month) +"/"+ Integer.toString(year);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Calendar startdate = Calendar.getInstance();
    startdate.setTime(sdf.parse(startDate));
    Calendar enddate = Calendar.getInstance();
    enddate.setTime(sdf.parse(endDate));

    while (!startdate.after(enddate)) {
        int day = startdate.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        if ((day != Calendar.FRIDAY) && (day != Calendar.SATURDAY)) {
            workingDays++;
        }

        // increment start date, otherwise while will give infinite loop
        startdate.add(Calendar.DATE, 1);
    }

    return workingDays;
}
//--------------- To be continued-elgoz2 elfo2----------------------------

public int statusCount(String id, String year, String month) throws SQLException, Exception
{
   // String strYear = Integer.toString(year);
    Connection con;
    ResultSet rs;
        int count = 0;
        con = DatabaseConnection.getConnection();
        String query = "SELECT COUNT(attendance) as statCount FROM attendance where userID = ? and attendance = \"Present\" and year = ? and month = ?";  //"SELECT COUNT(attendance) as statCount FROM attendance where userID = ? and attendance = \"Present\" and month = ? and year = ?";

        PreparedStatement pat = con.prepareStatement(query);
        
        pat.setString(1, id);
        pat.setString(2, year);
        pat.setString(3, month);
        rs = pat.executeQuery();
        while (rs.next()){
        count = rs.getInt("statCount");}
        
        
    return count;
}
public List<Map<Object, Object>>  checkStatus(String id, String year, String month) throws SQLException, ClassNotFoundException, Exception{
    int num = statusCount(id, year, month);
    //LocalDate localDate = LocalDate.of(1, month, 1);
    //String strMonth = localDate.getMonth().name();
        List<Map<Object, Object>>  genderCount = new ArrayList<Map<Object, Object>> ();

        Connection con;
        ResultSet rs;
        PreparedStatement pat;
        con = DatabaseConnection.getConnection();
        String query = "SELECT status, COUNT(status) FROM attendance where userID = ? and attendance = \"Present\" and year = ? and month = ? group by status"; //+ id + " AND month = " + month + " AND year = " + year + " group by status";
         pat = con.prepareStatement(query);
         pat.setString(1, id);
         pat.setString(2, year);
         pat.setString(3, month);
        //Statement st = con.createStatement();
        rs = pat.executeQuery();
       
        while (rs.next())
        {
            //HashMap<Object, Object>  map = new HashMap<Object, Object>();
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.put("label",rs.getString(1));
            map.put("y",rs.getInt(2)*100.0/num);
            genderCount.add((Map<Object, Object>) map);
        }
        pat.close();
        con.close();
        
        return genderCount;
}

}


