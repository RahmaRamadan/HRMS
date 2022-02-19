package Algorithms.Evaluation;


import DataAccess.Evaluation.Training_Data_Access;
import Entity.Training;
import Entity.Training_Acceptance;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zak
 */


public class Trainings_Management 
{
             
    public boolean addTraining(Training t)
    {
        Training_Data_Access d = new Training_Data_Access();
        boolean add ;
        add = d.setTraining(t);
        return add;
    }
    
    public boolean deleteTraining(int t_id)
    {
        Training_Data_Access d = new Training_Data_Access();
        boolean delete ;
        delete = d.deleteTraining(t_id);
        return delete;
    }
    
    public boolean checkThereAreTrainings()
    {
        Training_Data_Access a = new Training_Data_Access();
        ArrayList<Training> Get_Trainings = a.Get_Trainings_Data();
        if(!Get_Trainings.isEmpty())
        {
            return true;
        }
        return false ;
    }
    
    public ArrayList<Training> get_Trainings()
    {
        Training_Data_Access a = new Training_Data_Access();
        ArrayList<Training> T = a.Get_Trainings_Data();
        return T ;
    }
    
    
    public ArrayList<String> get_Training_skills(int id)
    {
        Training_Data_Access a = new Training_Data_Access();
        ArrayList<String> T = a.get_training_Skills(id);
        return T ;
    }
    
    
   
    public boolean addEnrollScore(String emp_id , int t_id , double s)  
    {
        Training_Data_Access a = new Training_Data_Access();
        boolean add ;
        add = a.insert_trainScore(emp_id, t_id,s);
        return add;
    }
    
    public ArrayList<Training_Acceptance> acceptt(int t_id)
    {
        ArrayList<Training_Acceptance> ress = new ArrayList<>();
        Training_Data_Access a = new Training_Data_Access();
        ress = a.getAcceptedEmployees(t_id);
        return ress; 
    }
}
