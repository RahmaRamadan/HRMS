/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Evaluation;
import DataAccess.EmployeesAffairs.Employee_DataAccess_Interface;
import DataAccess.EmployeesAffairs.MySQL_Employee_DataAccess;
import DataAccess.Evaluation.Training_Data_Access;
import Entity.Employee_Data;
import Entity.Training;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.Catch;
//import org.python.core.PyInstance;  
//import org.python.util.PythonInterpreter; 

/**
 *
 * @author Zak
 */
public class Similarity 
{
    Training_Data_Access data = new Training_Data_Access();
    MySQL_Employee_DataAccess empp = new MySQL_Employee_DataAccess();
    ArrayList<String> t_skills = new ArrayList<>();
    ArrayList<String> emp_skills = new ArrayList<>();
    String employee_skills = "" ;
    String training_skiils = "" ;
    String s = null;
    String n="";
    
    public double get_skills_similarity(String emp_id , int t_id)
    {
        t_skills = data.get_training_Skills(t_id);
        emp_skills = empp.get_employee_Skills(emp_id);
        
        for(int i = 0 ; i < t_skills.size() ; i++)
        {
            training_skiils+= t_skills.get(i);
             if (i < t_skills.size() - 1)
             {
                training_skiils += ",";
            }
        }
        for(int i = 0 ; i < emp_skills.size() ; i++)
        {
            employee_skills+= emp_skills.get(i);
            if (i < emp_skills.size() - 1)
            {
                employee_skills += ",";
            }
        }
        
        training_skiils = training_skiils.replaceAll(" ", "_").toLowerCase();
        employee_skills = employee_skills.replaceAll(" ", "_").toLowerCase();
        
        
         try {
      
            Process p = Runtime.getRuntime().exec("python C:\\Users\\maria\\OneDrive\\Desktop\\GPCodes\\training.py "+training_skiils+" "+employee_skills);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
           // System.out.println("Here is the standard output of the command:\n");
            
            while ((s = stdInput.readLine()) != null) {
             n=s;  
            }
          //  System.exit(0);
        }
        catch (IOException e) {
          //  System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
       // System.out.print(Double.parseDouble(n));
       return Double.parseDouble(n); 
    }
    
    
}
