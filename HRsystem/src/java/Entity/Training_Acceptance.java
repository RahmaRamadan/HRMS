/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author egypt2
 */
public class Training_Acceptance
{
    int training_id ;
    String employee_id ;
    double score ;
    
    public void setTrainingID(int t)
    {
        training_id = t ;
    }
    
    public int getTrainingID()
    {
        return training_id;
    }
    
    public void setEmployeeID(String id)
    {
        employee_id = id ;
    }
     
    public String getEmployeeID()
    {
        return employee_id;
    }
    
    public void setScore(double s )
    {
        score = s ;
    }
    
    public double getScore()
    {
        return score;
    }
    
    
}
